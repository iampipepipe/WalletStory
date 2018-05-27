package com.example.x.walletstory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private PrefManager prefManager;

    private DatabaseHandler mydb = new DatabaseHandler(this);
    private List<Data> dataIn = new ArrayList<>();
    private List<Data> dataEx = new ArrayList<>();
    private DataList data = new DataList();
    private Cursor cur;

    private static final String PREF_NAME = "MyPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Checking for the first time launch */
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        /* Making notification bar transparent */
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.button_skip);
        btnNext = (Button) findViewById(R.id.button_next);

        SharedPreferences pref = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        int counter = pref.getInt("counter",1);

        if(counter==1) {

            mydb.getWritableDatabase();
            //first income category
            mydb.addCategoryRecord("Salary", "income", R.mipmap.salary);
            mydb.addCategoryRecord("Selling", "income", R.mipmap.sale);
            mydb.addCategoryRecord("Award", "income", R.mipmap.award);
            mydb.addCategoryRecord("Interest Money", "income", R.mipmap.interest);
            mydb.addCategoryRecord("Gifts", "income", R.mipmap.gift);
            mydb.addCategoryRecord("Others", "income", R.mipmap.transaction);

            //first expense category
            mydb.addCategoryRecord("Food & Drink", "expense", R.mipmap.food);
            mydb.addCategoryRecord("Shopping", "expense", R.mipmap.shopping);
            mydb.addCategoryRecord("Transport", "expense", R.mipmap.transport);
            mydb.addCategoryRecord("Home", "expense", R.mipmap.home);
            mydb.addCategoryRecord("Entertainment", "expense", R.mipmap.entertainment);
            mydb.addCategoryRecord("Bills & Fees", "expense", R.mipmap.bills);
            mydb.addCategoryRecord("Car", "expense", R.mipmap.car);
            mydb.addCategoryRecord("Travel", "expense", R.mipmap.travel);
            mydb.addCategoryRecord("Family & Personal", "expense", R.mipmap.family);
            mydb.addCategoryRecord("Health", "expense", R.mipmap.health);
            mydb.addCategoryRecord("Education", "expense", R.mipmap.education);
            mydb.addCategoryRecord("Groceries", "expense", R.mipmap.groceries);
            mydb.addCategoryRecord("Gifts", "expense", R.mipmap.gift);
            mydb.addCategoryRecord("Sport & Hobbies", "expense", R.mipmap.sport);
            mydb.addCategoryRecord("Beauty", "expense", R.mipmap.beauty);
            mydb.addCategoryRecord("Work", "expense", R.mipmap.work);
            mydb.addCategoryRecord("Others", "expense", R.mipmap.transaction);

            mydb.close();


        }

        editor.putInt("counter",++counter);
        editor.commit();


        mydb.getWritableDatabase();
        cur = mydb.getIncomeCategoryAllRecord();
        if (cur.moveToFirst()) {
            while (!cur.isAfterLast()) {
                int nameCol = cur.getColumnIndex(mydb.getCategoryName());
                int typeCol = cur.getColumnIndex(mydb.getCategoryType());
                int iconCol = cur.getColumnIndex(mydb.getCategoryIcon());
                dataIn.add(new Data(cur.getString(nameCol), cur.getString(typeCol), cur.getInt(iconCol)));
                cur.moveToNext();
            }
        }

        data.setIncomesList(dataIn);



        cur = mydb.getExpenseCategoryAllRecord();
        if (cur.moveToFirst()) {
            while (!cur.isAfterLast()) {
                int nameCol = cur.getColumnIndex(mydb.getCategoryName());
                int typeCol = cur.getColumnIndex(mydb.getCategoryType());
                int iconCol = cur.getColumnIndex(mydb.getCategoryIcon());
                dataEx.add(new Data(cur.getString(nameCol), cur.getString(typeCol), cur.getInt(iconCol)));
                cur.moveToNext();
            }
        }

        data.setExpensesList(dataEx);

        mydb.close();


        /* Layouts of all welcome sliders */
        layouts = new int[] {
                R.layout.welcome_slide1,
                R.layout.welcome_slide2 };

        /* Making notification bar transparent */
        changeStatusBarColor();

        /* Add bottom dots */
        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = getItem(+1);
                /* Check for the last page */
                if(current < layouts.length) {
                    /* Move to next screen */
                    viewPager.setCurrentItem(current);
                }
                else {
                    launchHomeScreen();
                }
            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }

    /* ViewPager Change Listener */
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            /* changing the next button text 'NEXT' / 'GOT IT' */
            if (position == layouts.length - 1) {
                /* last page. make button text to GOT IT */
                btnNext.setText(getString(R.string.Start));
                btnSkip.setVisibility(View.GONE);
            } else {
                /* still pages are left */
                btnNext.setText(getString(R.string.Next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
