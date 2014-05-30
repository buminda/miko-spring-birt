package com.miko.demo.birt.service;

import com.miko.demo.birt.model.Car;
import com.miko.demo.birt.model.NCar;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */
public interface NeoCarService {

    Car findByMake(String make);

    NCar findByMakeNeo(String make);

    NCar findByMakeFord();

    NCar findByMakeForWithGarage();

    NCar findByModel(String model);

    NCar findByYear(String year);
}
