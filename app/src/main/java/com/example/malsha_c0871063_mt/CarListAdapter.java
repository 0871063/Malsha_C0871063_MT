package com.example.malsha_c0871063_mt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.malsha_c0871063_mt.databinding.RowCarListLayoutBinding;

import java.util.List;

public class CarListAdapter extends ArrayAdapter {

    private Context context;
    int resLayout;

    public CarListAdapter(@NonNull Context context, int resource, @NonNull List userList) {
        super(context, resource, userList);
        this.context = context;
        this.resLayout = resource;
    }


    public CarListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resLayout = resource;
    }

    @Override
    public int getCount() {
        return RentCar.rentCarList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RowCarListLayoutBinding binding = RowCarListLayoutBinding.inflate(LayoutInflater.from(context));

        binding.nameTV.setText(RentCar.rentCarList.get(position).getName());
        binding.amountTV.setText(Double.toString(RentCar.rentCarList.get(position).getPrice()));
        binding.totalPriceETTV.setText(Double.toString(RentCar.rentCarList.get(position).getTotalPrice()));
        return binding.getRoot();


    }
}