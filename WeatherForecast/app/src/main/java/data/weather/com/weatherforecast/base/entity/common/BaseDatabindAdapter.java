package data.weather.com.weatherforecast.base.entity.common;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import data.weather.com.weatherforecast.utility.smoothscroller.SnappingLinearLayoutManager;

public class BaseDatabindAdapter extends BaseObservable {


    @BindingAdapter({"bind:setDefaultAdapter"})
    public static void setDefaultAdapter(RecyclerView view, Object adapter) {
        view.hasFixedSize();
        view.setLayoutManager(new SnappingLinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL,false));
        view.setAdapter((RecyclerView.Adapter) adapter);
    }

    @BindingAdapter({"bind:setDefaultGridAdapter"})
    public static void setDefaultGridAdapter(RecyclerView view, Object adapter) {
        view.removeAllViews();
        view.hasFixedSize();
        view.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        view.setAdapter((RecyclerView.Adapter) adapter);

    }
}
