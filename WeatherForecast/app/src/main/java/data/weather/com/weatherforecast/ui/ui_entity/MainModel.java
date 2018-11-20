package data.weather.com.weatherforecast.ui.ui_entity;

import android.databinding.Bindable;

import data.weather.com.weatherforecast.adapter.WeatherAdapter;
import data.weather.com.weatherforecast.base.entity.common.BaseDatabindAdapter;
import data.weather.com.weatherforecast.BR;

public class MainModel extends BaseDatabindAdapter {
    private String cityName;
    private String maxWeather;
    private String minWeather;
    private String updateweatherHeading;
    private WeatherAdapter weatherAdapter;


    @Bindable
    public WeatherAdapter getWeatherAdapter() {
        return weatherAdapter;
    }

    public void setWeatherAdapter(WeatherAdapter weatherAdapter) {
        this.weatherAdapter = weatherAdapter;
        notifyPropertyChanged(BR.weatherAdapter);
    }

    @Bindable
   public String getCityName() {
        return cityName;
    }

    @Bindable
    public String getMaxWeather() {
        return maxWeather;
    }

    @Bindable
    public String getMinWeather() {
        return minWeather;
    }

    @Bindable
    public String getUpdateweatherHeading() {
        return updateweatherHeading;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
        notifyPropertyChanged(BR.cityName);
    }

    public void setMaxWeather(String maxWeather) {
        this.maxWeather = maxWeather;
        notifyPropertyChanged(BR.maxWeather);
    }

    public void setMinWeather(String minWeather) {
        this.minWeather = minWeather;
        notifyPropertyChanged(BR.minWeather);
    }

    public void setUpdateweatherHeading(String updateweatherHeading) {
        this.updateweatherHeading = updateweatherHeading;
        notifyPropertyChanged(BR.updateweatherHeading);
    }
}
