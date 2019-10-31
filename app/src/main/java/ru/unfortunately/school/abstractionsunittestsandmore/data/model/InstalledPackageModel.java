package ru.unfortunately.school.abstractionsunittestsandmore.data.model;

import android.graphics.drawable.Drawable;

public class InstalledPackageModel {

    private String mAppName;

    private String mAppPackageName;

    private Drawable mAppIcon;

    public InstalledPackageModel(String appName, String appPackageName, Drawable appIcon){
        mAppIcon = appIcon;
        mAppName = appName;
        mAppPackageName = appPackageName;
    }

    public String getAppName(){
        return mAppName;
    }
    public String getAppPackageName(){
        return mAppPackageName;
    }
    public Drawable getAppIcon(){
        return mAppIcon;
    }
    public void setAppName(String appName){
        mAppName = appName;
    }
    public void setAppPackageName(String appPackageName){
        mAppPackageName = appPackageName;
    }
    public void setmAppIcon(Drawable appIcon){
        mAppIcon = appIcon;
    }
}
