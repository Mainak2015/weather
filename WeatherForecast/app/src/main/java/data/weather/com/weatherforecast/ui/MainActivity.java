package data.weather.com.weatherforecast.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import data.weather.com.weatherforecast.R;
import data.weather.com.weatherforecast.BR;
import data.weather.com.weatherforecast.adapter.WeatherAdapter;
import data.weather.com.weatherforecast.base.BaseActivity;
import data.weather.com.weatherforecast.model.WeatherFormateData;
import data.weather.com.weatherforecast.model.WeatherMainResponse;
import data.weather.com.weatherforecast.network.WebServiceCall;
import data.weather.com.weatherforecast.ui.ui_entity.MainModel;
import data.weather.com.weatherforecast.utility.AppData;
import data.weather.com.weatherforecast.utility.ConnectionCheck;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements WeatherFormateData.WeatherDetailsListerner {

    MainModel mainModel = new MainModel();
    List<WeatherFormateData> weatherFormateDataList = new ArrayList<WeatherFormateData>();
    WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToolBar(true);
        setContentOfViewWithBinding(R.layout.activity_main, this, BR.MainModel, mainModel);
        setTittle("Weather Details");


        weatherAdapter = new WeatherAdapter(this, weatherFormateDataList);
        mainModel.setWeatherAdapter(weatherAdapter);
        checkNetworkConnection();
    }


    private void checkNetworkConnection() {
        if (ConnectionCheck.isOnlineSocket(this)) {
            getWeatherData();
        } else {
            AppData.showToast(this, getResources().getString(R.string.err_msg_internet));
        }
    }

    private void getWeatherData() {
        isLoading(true);

        final Call<WeatherMainResponse> weatherMainResponseCall = WebServiceCall.service().getWeatherAllData(AppData.WEATHER_KEY, AppData.CITY_NAME, AppData.MAX_DAYS);
        weatherMainResponseCall.enqueue(new Callback<WeatherMainResponse>() {
            @Override
            public void onResponse(Call<WeatherMainResponse> call, Response<WeatherMainResponse> response) {
                isLoading(false);
                try {
                    if (response.isSuccessful()) {
                        if (response.body().getForecast().getForecastday() != null && response.body().getForecast().getForecastday().size() > 0) {
                            if (weatherFormateDataList.size() > 0) {
                                weatherFormateDataList.clear();
                            }
                            for (int i = 0; i < response.body().getForecast().getForecastday().size(); i++) {
                                WeatherFormateData weatherFormateData = new WeatherFormateData(MainActivity.this);

                                weatherFormateData.setCityName(AppData.CITY_NAME);
                                weatherFormateData.setDate(response.body().getForecast().getForecastday().get(i).getDate());
                                weatherFormateData.setMaxtemp(String.valueOf(response.body().getForecast().getForecastday().get(i).getDay().getMaxtempC()));
                                weatherFormateData.setMintemp(String.valueOf(response.body().getForecast().getForecastday().get(i).getDay().getMintempC()));
                                weatherFormateData.setSunrise(response.body().getForecast().getForecastday().get(i).getAstro().getSunrise());
                                weatherFormateData.setSunset(response.body().getForecast().getForecastday().get(i).getAstro().getSunset());
                                weatherFormateData.setCondition(response.body().getForecast().getForecastday().get(i).getDay().getCondition().getText());

                                weatherFormateDataList.add(weatherFormateData);

                            }

                            //update current weather---
                            mainModel.setCityName(weatherFormateDataList.get(0).getCityName());
                            mainModel.setMaxWeather(weatherFormateDataList.get(0).getMaxtemp());
                            mainModel.setMinWeather(weatherFormateDataList.get(0).getMintemp());
                            mainModel.setUpdateweatherHeading(getString(R.string.current_n_upcoming_weather));

                            weatherAdapter.setupdateNewdata(weatherFormateDataList);


                        }
                    }
                } catch (Exception e) {
                    AppData.showToast(MainActivity.this, getString(R.string.please_try_again));
                }


            }

            @Override
            public void onFailure(Call<WeatherMainResponse> call, Throwable t) {
                isLoading(false);
            }
        });
    }

    @Override
    public void clickDetailsWeather(View view,  WeatherFormateData weatherFormateData, int position) {

        Bundle bundle = new Bundle();
        bundle.putParcelable("WeatherData", weatherFormateData);
        AppData.startNewActivity(this, WeatherDetailsActivity.class,bundle,false);
    }
}
