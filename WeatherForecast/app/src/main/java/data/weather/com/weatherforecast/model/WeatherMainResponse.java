package data.weather.com.weatherforecast.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherMainResponse {

    @SerializedName("forecast")
    @Expose
    private Forecast forecast;


    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

}
