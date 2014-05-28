package com.miko.demo.birt.model;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@NodeEntity
public class NCar extends AbstractNeoEntity{

    @Indexed
    private String make;

    @Indexed
    private String model;

    @Indexed
    private String year;

    private NGarage garage;

    public NCar() {
    }

    public NCar(String make, String model, String year) {

        Assert.hasText(make);
        Assert.hasText(model);
        Assert.hasText(year);

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

    public NGarage getGarage() {
        return garage;
    }

    public void setGarage(NGarage garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append("NeoCar-{ model= ").append(model);
        builder.append(", make= ").append(make);
        builder.append(", year= ").append(year);
        builder.append(", garage= ").append(garage);
        return builder.append('}').toString();
    }
}
