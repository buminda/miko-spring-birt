package com.miko.demo.birt.model;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@NodeEntity
public class NGarage extends AbstractNeoEntity {

    @Indexed
    private String name;

    @RelatedTo(type = "located")
    private Set<NCar> cars = new HashSet<NCar>();

    public NGarage() {
    }

    public NGarage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<NCar> getCars() {
        return cars;
    }

    public void setCars(Set<NCar> cars) {
        this.cars = cars;
    }

    public boolean addCar(NCar car){
        Assert.notNull(car);
        return cars.add(car);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append("NeoGarage-{ name= ").append(name);
        return builder.append('}').toString();
    }
}
