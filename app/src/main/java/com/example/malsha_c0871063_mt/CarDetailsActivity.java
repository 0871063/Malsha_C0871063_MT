package com.example.malsha_c0871063_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.malsha_c0871063_mt.databinding.ActivityCarDetailsBinding;
import com.example.malsha_c0871063_mt.databinding.ActivityCarListBinding;

import java.util.ArrayList;

public class CarDetailsActivity extends AppCompatActivity {

    private ActivityCarDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String position = intent.getStringExtra("position");
        int index = Integer.parseInt(position);
        RentCar car = RentCar.rentCarList.get(index);
        binding.carDetailTV.setText(car.toString());
    }

}