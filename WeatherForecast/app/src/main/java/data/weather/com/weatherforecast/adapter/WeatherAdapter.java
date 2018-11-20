package data.weather.com.weatherforecast.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import data.weather.com.weatherforecast.R;
import data.weather.com.weatherforecast.BR;
import data.weather.com.weatherforecast.model.WeatherFormateData;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private   List<WeatherFormateData> weatherFormateDataList;
    private Activity activity;


    public WeatherAdapter(Activity mactivity,  List<WeatherFormateData> mWeatherFormateDataList) {
        weatherFormateDataList = mWeatherFormateDataList;
        activity = mactivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.child_item_row, viewGroup, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ViewDataBinding viewDataBinding = viewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.WeatherFormateData, weatherFormateDataList.get(position));
        viewDataBinding.setVariable(BR.Position, position);
        viewDataBinding.setVariable(BR.WeatherDetailsListerner, activity);
    }

    @Override
    public int getItemCount() {
        return (null != weatherFormateDataList ? weatherFormateDataList.size() : 0);
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mViewDataBinding;

        public ViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            mViewDataBinding = viewDataBinding;
            mViewDataBinding.executePendingBindings();
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }

    public void setupdateNewdata(List<WeatherFormateData> mweatherFormateUpdateList) {
        weatherFormateDataList = mweatherFormateUpdateList;
        notifyDataSetChanged();
    }
}