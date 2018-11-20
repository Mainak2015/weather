package data.weather.com.weatherforecast.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import data.weather.com.weatherforecast.R;

public class AppData {

    public static String TAG = "Weather ::::";
    public static final String BASE_URL = "https://api.apixu.com/v1/";
    //set your own key from https://www.apixu.com/
    public final static String WEATHER_KEY ="XXXXXXXXXXXXXXXXXXXXXXX";
    public final static String CITY_NAME ="Paris";
    public final static String MAX_DAYS ="6";





    public static void showNoInterNetToast(Context context) {
        Toast.makeText(context, context.getResources().getString(R.string.err_msg_internet), Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static void showException(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void startNewActivity(Activity activity, Class className, boolean clearStack) {
        Intent intent = new Intent(activity, className);
        if (clearStack)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }


    public static void startNewActivityForResult(Activity activity, Class className, int code) {
        Intent intent = new Intent(activity, className);
        activity.startActivityForResult(intent, code);

    }

    public static void startNewActivity(Activity activity, Class className, Bundle bundle, boolean clearStack) {
        Intent intent = new Intent(activity, className);
        intent.putExtras(bundle);
        if (clearStack)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);

    }


}
