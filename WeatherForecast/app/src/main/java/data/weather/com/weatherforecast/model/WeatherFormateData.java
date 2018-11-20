package data.weather.com.weatherforecast.model;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;


import data.weather.com.weatherforecast.R;

public class WeatherFormateData  implements Parcelable{
    private Activity activity;
    private String cityName;
    private String date;
    private String maxtemp;
    private String mintemp;
    private String sunrise;
    private String sunset;
    private String condition;

    public WeatherFormateData(Activity mActivity) {
        activity = mActivity;
    }




   public String getCityName() {
       String m_cityName = "City "+cityName;
        return m_cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;

    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

   public String getMaxtemp() {
        String m_maxtemp = "Max temperature   "+ maxtemp + "\u2103";
        return m_maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;

    }


    public String getMintemp() {
        String m_mintemp = "Min temperature   "+ mintemp + "\u2103";
        return m_mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;

    }


    public String getSunrise() {
        String m_sunrise = "Sunrise Time   "+sunrise;
        return m_sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;

    }


   public String getSunset() {
        String m_sunset = "Sunset Time   "+sunset;
        return m_sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;

    }


   public String getCondition() {
        String m_condition = "Weather  "+ condition;
        return m_condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;

    }

    public interface WeatherDetailsListerner{
        void clickDetailsWeather(View view, WeatherFormateData weatherFormateData, int position);
    }


    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cityName);
        dest.writeString(date);
        dest.writeString(maxtemp);
        dest.writeString(mintemp);
        dest.writeString(sunrise);
        dest.writeString(sunset);
        dest.writeString(condition);
    }

    public WeatherFormateData(Parcel in) {
        cityName = in.readString();
        date = in.readString();
        maxtemp =in.readString();
        mintemp = in.readString();
        sunrise = in.readString();
        sunset = in.readString();
        condition = in.readString();
    }

    public static final Creator<WeatherFormateData> CREATOR = new Creator<WeatherFormateData>() {
        @Override
        public WeatherFormateData createFromParcel(Parcel source) {
            return new WeatherFormateData(source);
        }

        @Override
        public WeatherFormateData[] newArray(int size) {
            return new WeatherFormateData[size];
        }
    };

}
