package data.weather.com.weatherforecast.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import data.weather.com.weatherforecast.BR;
import data.weather.com.weatherforecast.R;
import data.weather.com.weatherforecast.base.BaseActivity;
import data.weather.com.weatherforecast.model.WeatherFormateData;
import data.weather.com.weatherforecast.model.WeatherSelectedDataModel;

public class WeatherDetailsActivity extends BaseActivity {

    WeatherFormateData weatherFormateData;
    WeatherSelectedDataModel weatherSelectedDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToolBar(true);


        try {
            if (getIntent().hasExtra("WeatherData")) {
                weatherFormateData = (WeatherFormateData) getIntent().getParcelableExtra("WeatherData");

                weatherSelectedDataModel = new WeatherSelectedDataModel();
                weatherSelectedDataModel.setCityName(weatherFormateData.getCityName());
                weatherSelectedDataModel.setSunrise(weatherFormateData.getSunrise());
                weatherSelectedDataModel.setSunset(weatherFormateData.getSunset());
                weatherSelectedDataModel.setMaxtemp(weatherFormateData.getMaxtemp());
                weatherSelectedDataModel.setMintemp(weatherFormateData.getMintemp());
                weatherSelectedDataModel.setCondition(weatherFormateData.getCondition());
            }
        }catch (Exception e){
            e.printStackTrace();
            onBackPressed();
        }

        setContentOfViewWithBinding(R.layout.activity_weather_details, this, BR.WeatherSelectedDataModel, weatherSelectedDataModel);
        setTittle("Weather Details");
        showBackButton();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
