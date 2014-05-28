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

    Car findByModel(String model);

    NCar findByModelNeo(String model);

    Car findByYear(String year);

    NCar findByYearNeo(String year);
}
