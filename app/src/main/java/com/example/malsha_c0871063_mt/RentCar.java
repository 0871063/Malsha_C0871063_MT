package com.example.malsha_c0871063_mt;

import java.util.ArrayList;

public class RentCar {
    private String name;
    private double price;
    private double totalPrice;
    private int dayCount;
    private boolean gpsSelected;
    private boolean childSeatSelected;
    private boolean millage;
    private String age;

    public RentCar(String name, double price, double totalPrice, int dayCount, boolean gpsSelected, boolean childSeatSelected, boolean millage, String age) {
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.dayCount = dayCount;
        this.gpsSelected = gpsSelected;
        this.childSeatSelected = childSeatSelected;
        this.millage = millage;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public boolean isGpsSelected() {
        return gpsSelected;
    }

    public void setGpsSelected(boolean gpsSelected) {
        this.gpsSelected = gpsSelected;
    }

    public boolean isChildSeatSelected() {
        return childSeatSelected;
    }

    public void setChildSeatSelected(boolean childSeatSelected) {
        this.childSeatSelected = childSeatSelected;
    }

    public boolean isMillage() {
        return millage;
    }

    public void setMillage(boolean millage) {
        this.millage = millage;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "Car name : " + name + '\n' +
                "Price : " + price + '\n' +
                "Total Price : " + totalPrice + '\n' +
                "Day Count : " + dayCount + '\n' +
                "Gps Selected : " + gpsSelected + '\n' +
                "Child Seat Selected : " + childSeatSelected + '\n' +
                "Unlimited millage Selected :" + millage + '\n' +
                "Driver's age is '" + age + '\n';
    }

    public static ArrayList<RentCar> rentCarList = new ArrayList<>();
}
