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
