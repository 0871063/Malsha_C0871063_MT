package com.example.malsha_c0871063_mt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.malsha_c0871063_mt.databinding.ItemDropdownBinding;

public class CarAdapter extends ArrayAdapter<Car> {
    Context context;

    public CarAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Nullable
    @Override
    public Car getItem(int position) {
        return Car.carList.get(position);
    }

    @Override
    public int getCount() {
        return Car.carList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            ItemDropdownBinding binding = ItemDropdownBinding.inflate(LayoutInflater.from(context),parent,false);
            binding.getRoot().setText(Car.carList.get(position).getName());
            return binding.getRoot();
        }
        else{
            return super.getView(position,convertView,parent);
        }

    }
}
