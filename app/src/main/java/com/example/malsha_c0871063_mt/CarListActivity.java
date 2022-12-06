package com.example.malsha_c0871063_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.malsha_c0871063_mt.databinding.ActivityCarListBinding;

public class CarListActivity extends AppCompatActivity {

    private ActivityCarListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CarListAdapter adapter = new CarListAdapter(this, R.layout.row_car_list_layout);
        binding.carlist.setAdapter(adapter);


        binding.carlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loaCarData(position);
            }
        });

    }
    private void loaCarData(int position){
        Intent intent = new Intent(getApplicationContext(), CarDetailsActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}