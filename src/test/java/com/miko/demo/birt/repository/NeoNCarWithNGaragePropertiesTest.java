package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NCar;
import com.miko.demo.birt.model.NGarage;
import com.miko.demo.birt.service.NeoCarService;
import com.miko.demo.birt.service.NeoGarageService;
import com.miko.demo.birt.util.NCarConsts;
import com.miko.demo.birt.util.NGarageConsts;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/miko-app-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NeoNCarWithNGaragePropertiesTest implements NCarConsts, NGarageConsts {

    private final Logger logger = LoggerFactory.getLogger(NeoNCarWithNGaragePropertiesTest.class);

    @Autowired
    NCarEntityRepository nCarEntityRepository;

    @Autowired
    NGarageEntityRepository nGarageEntityRepository;

    @Autowired
    NeoCarService neoCarService;

    @Autowired
    NeoGarageService neoGarageService;


    /**
     *
     *
     *
     * comments:
     * neo4j-community-2.0.0 version -> This test should not pass
     *                               -> NCar assigment to NGarages {GarageOne, GarageTwo} works
     * neo4j-community-2.0.3 version -> NCar assigment to NGarages {GarageOne, GarageTwo} doesn't work properly
     *                               -> All NCars assigned to the NGarage {GarageOne}
     */
//    @Test
//    public void checkNCarAndNGarageRelTest(){
//
//        EndResult<NCar> cars = nCarEntityRepository.findAll();
//        Assert.notNull(cars);
//
//        NGarage garage = neoGarageService.findByName(NGARAGE_TWO);
//        Assert.notNull(garage);
//
//        for(NCar car: cars){
//            Assert.isTrue(car.getGarage().equals(garage));
//        }
//
//    }


    /**
     *  neo4j-community-2.0.0 version
     *  neo4j-community-2.0.3 version
     *  Doesn't work -> missing reference to NGarage.name property
     */
    @Test
    public void checkNCarsProperties1(){
        NCar ford = nCarEntityRepository.findByMake(NFORD).get(0);
        Assert.notNull(ford);
        Assert.notNull(ford.getGarage().getId());


        Assert.isTrue(ford.getGarage().getName().equals(NGARAGE_ONE));
    }

    /**
     * neo4j-community-2.0.0 version
     * neo4j-community-2.0.3 version
     *
     * this solution works
     *
     */
    @Test
    public void checkNCarsProperties2(){
        NCar ford = nCarEntityRepository.findByMake(NFORD).get(0);
        Assert.notNull(ford);
        Assert.notNull(ford.getGarage().getId());

        NGarage garage = nGarageEntityRepository.findOne(ford.getGarage().getId());
        Assert.isTrue(garage.getName().equals(NGARAGE_ONE));
    }

}
