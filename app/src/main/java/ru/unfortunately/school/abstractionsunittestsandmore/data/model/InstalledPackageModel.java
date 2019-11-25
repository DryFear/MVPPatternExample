package ru.unfortunately.school.abstractionsunittestsandmore.data.model;

import android.graphics.drawable.Drawable;

public class InstalledPackageModel {

    private String mAppName;

    private String mAppPackageName;

    private Drawable mAppIcon;

    private boolean mIsSystem;

    public InstalledPackageModel(String appName, String appPackageName, Drawable appIcon, boolean isSystem){
        mAppIcon = appIcon;
        mAppName = appName;
        mAppPackageName = appPackageName;
        mIsSystem = isSystem;
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
    public void setAppIcon(Drawable appIcon){
        mAppIcon = appIcon;
    }

    public boolean isSystem() {
        return mIsSystem;
    }

    public void setSystem(boolean system) {
        mIsSystem = system;
    }
}
