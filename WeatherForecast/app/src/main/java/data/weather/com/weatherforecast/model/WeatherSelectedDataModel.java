package data.weather.com.weatherforecast.model;


import android.databinding.Bindable;
import data.weather.com.weatherforecast.BR;

import data.weather.com.weatherforecast.base.entity.common.BaseDatabindAdapter;

public class WeatherSelectedDataModel extends BaseDatabindAdapter {

    private String cityName;
    private String date;
    private String maxtemp;
    private String mintemp;
    private String sunrise;
    private String sunset;
    private String condition;

    public WeatherSelectedDataModel() {
    }

    @Bindable
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
        notifyPropertyChanged(BR.cityName);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

   @Bindable
   public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
        notifyPropertyChanged(BR.maxtemp);
    }

   @Bindable
   public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
        notifyPropertyChanged(BR.mintemp);
    }

    @Bindable
    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
        notifyPropertyChanged(BR.sunrise);
    }

    @Bindable
    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
        notifyPropertyChanged(BR.sunset);
    }

   @Bindable
   public String getCondition() {
             return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        notifyPropertyChanged(BR.condition);
    }


}
