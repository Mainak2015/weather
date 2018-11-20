package data.weather.com.weatherforecast.network;



import data.weather.com.weatherforecast.model.WeatherMainResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
//key=4f14e85c7776406085851545180509&q=Paris&days=5
   @GET("forecast.json?")
   Call<WeatherMainResponse> getWeatherAllData(@Query("key") String key, @Query("q") String city, @Query("days") String maxDays);

}
