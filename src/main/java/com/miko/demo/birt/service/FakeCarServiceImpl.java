package com.miko.demo.birt.service;

import com.miko.demo.birt.model.Car;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
