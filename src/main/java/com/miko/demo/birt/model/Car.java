package com.miko.demo.birt.model;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/23/14
 */
public class Car {

    private String make;
    private String model;
    private String year;
    private String garage;

    public Car() {
    }

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append("Car { model= ").append(model);
        builder.append(", make= ").append(make);
        builder.append(", year= ").append(year);
        if(garage != null) builder.append(", garage= ").append(garage);
        return builder.append('}').toString();
    }
}
