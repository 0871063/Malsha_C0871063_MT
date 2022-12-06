package com.example.malsha_c0871063_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.malsha_c0871063_mt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    private int days = 0;
    private double tax = 0.13;
    private boolean gpsSelected;
    private boolean childSeatSelected;
    private boolean millageSelected;
    private double totalAmount = 0;
    private String age;
    private Car selectedCar ;
    private ActivityMainBinding binding;
    CarAdapter adapter;
    private double amountForAge = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addCars();

        adapter = new CarAdapter(this, android.R.layout.simple_dropdown_item_1line);
        binding.carSpinner.setAdapter(adapter);

        binding.carSpinner.setOnItemSelectedListener(this);
        binding.betweenTwentyRadioButton.setOnClickListener(this);
        binding.lessThanTwentyRadioButton.setOnClickListener(this);
        binding.sixtyRadioButton.setOnClickListener(this);

        binding.quantitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                days = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String daycount = String.valueOf(days) + " Days";
                binding.dayCountTV.setText(daycount);
                totalPrice();
            }
        });

        binding.viewDetailsBtn.setOnClickListener(
                v -> {
                    if(selectedCar == null){
                        Toast.makeText(this, "Please select the car.", Toast.LENGTH_SHORT).show();
                    }else {
                            if (days != 0) {
                                Toast.makeText(this, "Car Ordered", Toast.LENGTH_SHORT).show();
                                navigateToList();
                            }else {
                                Toast.makeText(this, "Please select the no of days.", Toast.LENGTH_SHORT).show();
                            }
                    }
                }
        );

        binding.gpsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gpsSelected = b;
                totalPrice();
            }
        });
        binding.childSeatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                childSeatSelected = b;
                totalPrice();
            }
        });
        binding.millageCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                millageSelected = b;
                totalPrice();
            }
        });

    }

    private void totalPrice(){
        if(selectedCar != null) {
            double priceForDayCount = days * selectedCar.getPrice();
            int dealId = binding.ageButtonGroup.getCheckedRadioButtonId();
            age = ((RadioButton) findViewById(dealId)).getText().toString();
            double optionAmount = amountForOptions();
            double totalPrice = priceForDayCount + optionAmount + amountForAge;
            double taxAmount = totalPrice * tax;
            totalAmount = taxAmount + totalPrice;
            String finalTotalString = String.format("%.2f", totalAmount);
            binding.totalPriceET.setText(finalTotalString);
        }else{
            binding.priceET.setText("0");
            binding.totalPriceET.setText("0");
        }
    }

    private void addCars(){
        Car.carList.add(new Car("Please choose a car",0.0));
        Car.carList.add(new Car("BMW",2500.0));
        Car.carList.add(new Car("Audi",3500.0));
        Car.carList.add(new Car("Cadillac",2000.0));
        Car.carList.add(new Car("Volks Wagon",4500.0));
        Car.carList.add(new Car("Mercedes",7000.0));
        Car.carList.add(new Car("Peugeot",1500.0));
        Car.carList.add(new Car("Zusuki",2450.0));
        Car.carList.add(new Car("AMW",1850.0));

    }
//    //
//    @Override
//    public void onClick(View v) {
//        totalPrice();
//    }

    @Override
    public void onClick(View v) {
//        age = v.toString();
        switch (v.getId()) {
            case R.id.lessThanTwentyRadioButton:
                amountForAge = 5.0;
                totalPrice();
                break;
            case R.id.betweenTwentyRadioButton:
                amountForAge = 0.0;
                totalPrice();;
                break;
            case R.id.sixtyRadioButton:
                amountForAge = -10.0;
                totalPrice();;
                break;
            default:
                break;
        }
    }

    private double amountForOptions(){
        double amountForOptions = 0.0;
        if (gpsSelected){
            amountForOptions += 5.0;
        }
        if(childSeatSelected){
            amountForOptions += 7.0;
        }
        if(millageSelected){
            amountForOptions += 10.0;
        }
        return  amountForOptions;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        selectedCar = Car.carList.get(position);
        binding.priceET.setText(String.valueOf(selectedCar.getPrice()));
        totalPrice();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        clearFields();
    }

    private void clearFields(){
        binding.quantitySeekBar.setProgress(0);
        binding.betweenTwentyRadioButton.setChecked(false);
        binding.sixtyRadioButton.setChecked(false);
        binding.lessThanTwentyRadioButton.setChecked(false);
        binding.childSeatCheckBox.setChecked(false);
        binding.millageCheckBox.setChecked(false);
        binding.gpsCheckBox.setChecked(false);
        binding.carSpinner.setSelection(0);
    }

    private void navigateToList(){
        String car = binding.carSpinner.getSelectedItem().toString();

        RentCar.rentCarList.add(new RentCar(car,selectedCar.getPrice(),totalAmount,days,gpsSelected,childSeatSelected,millageSelected,age));
        startActivity(new Intent(this, CarListActivity.class));
    }

}