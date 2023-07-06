package com.example.lab6_var4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;

public class Car {

    private String mark;
    private String model;
    private Integer year;
    private String color;
    private String vin;

    public Car(String mark, String model, Integer year, String color, String vin) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public String getMark() {
        return mark;
    }
    public String getModel() {
        return model;
    }
    public Integer getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public String getVin() {
        return vin;
    }



    public static ObservableList<Car> FindMark(String mark1, ObservableList<Car> list){



        ObservableList<Car> list1 = FXCollections.observableArrayList();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Car car = (Car) iterator.next();
            if(car.mark.toLowerCase().contains(mark1.toLowerCase())){
                list1.add(car);
            }
        }

        boolean result = list1.isEmpty();
        if(result) return null;

        return list1;
    }
}
