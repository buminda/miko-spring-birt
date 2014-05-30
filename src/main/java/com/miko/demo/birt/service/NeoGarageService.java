package com.miko.demo.birt.service;

import com.miko.demo.birt.model.NGarage;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */
public interface NeoGarageService {

    NGarage findByName(String name);

    int getCarNumberByName(String garageName);

}
