package com.miko.demo.birt.service;

import com.miko.demo.birt.model.Car;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/23/14
 */

@Service("carService")
public class FakeCarServiceImpl implements FakeCarService {
    @Override
    public List getAllCars() {
        Car car1 = new Car();
        car1.setYear("2000");
        car1.setMake("Chevrolet MIKO");
        car1.setModel("Corvette");
        Car car2 = new Car();
        car2.setYear("2005");
        car2.setMake("Dodge");
        car2.setModel("Viper");
        Car car3 = new Car();
        car3.setYear("2002");
        car3.setMake("Ford");
        car3.setModel("Mustang GT");
        List cars = Arrays.asList(car1, car2, car3) ;
        return cars ;
    }
}
