package com.example.x.walletstory;

public class Data {
    private String mText1;
    private String value;
    private String mText2;

    private int mIcon;

    public Data(String mText1,String value , String mText2/*int mIcon*/) {
        this.mText1 = mText1;

        this.value = value;
        this.mText2 = mText2;
        //this.mIcon = mIcon;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

    public  String getValue(){ return  value;}

    public  void  setValue(String value){ this.value = value;}

    /*public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }*/
}