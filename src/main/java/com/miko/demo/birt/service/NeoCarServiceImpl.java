package com.miko.demo.birt.service;

import com.miko.demo.birt.model.Car;
import com.miko.demo.birt.model.NCar;
import com.miko.demo.birt.repository.NCarEntityRepository;
import com.miko.demo.birt.repository.NGarageEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@Service("neoCarService")
public class NeoCarServiceImpl implements NeoCarService{

    private final Logger logger = LoggerFactory.getLogger(NeoCarServiceImpl.class);

    @Autowired
    NCarEntityRepository nCarEntityRepository;

    @Autowired
    NGarageEntityRepository nGarageEntityRepository;

    @Override
    public Car findByMake(String make) {

        List<NCar> cars = nCarEntityRepository.findByMake(make);

        NCar nCar = cars.get(0);

        Car result = new Car(nCar.getMake(), nCar.getModel(), nCar.getYear());
        // Neo2.0.0-community also Neo2.0.3 -> doesn't work
        //result.setGarage(nCar.getGarage().getId().toString());
        result.setGarage(nGarageEntityRepository.findOne(nCar.getGarage().getId()).getName());

        return result;
    }

    @Override
    public NCar findByMakeNeo(String make) {

        List<NCar> cars = nCarEntityRepository.findByMake(make);

        return cars.get(0);
    }

    @Override
    public NCar findByMakeFord() {
        return nCarEntityRepository.findByMakeFord();
    }

    @Override
    public NCar findByMakeForWithGarage() {

        NCar car = nCarEntityRepository.findByMakeFordWithGarage();
        car.setGarage(nGarageEntityRepository.findOne(car.getGarage().getId()));

        return car;
    }


    @Override
    public NCar findByModel(String model) {

        List<NCar> cars = nCarEntityRepository.findByModel(model);

        return cars.get(0);
    }

    @Override
    public NCar findByYear(String year) {

        List<NCar> cars = nCarEntityRepository.findByYear(year);

        return cars.get(0);
    }
}
