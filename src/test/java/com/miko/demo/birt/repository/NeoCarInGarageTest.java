package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NCar;
import com.miko.demo.birt.model.NGarage;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/miko-app-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NeoCarInGarageTest implements NGarageConsts {

    private final Logger logger = LoggerFactory.getLogger(NeoCarInGarageTest.class);

    @Autowired
    NCarEntityRepository nCarEntityRepository;

    @Autowired
    NGarageEntityRepository nGarageEntityRepository;


    @Test
    public void AcreateNGarageTest(){
        NGarage nGarage1 = new NGarage(NGARAGE_ONE);
        NGarage nGarage2 = new NGarage(NGARAGE_TWO);

        List<NGarage> garageList = new ArrayList<>();
        garageList.add(nGarage1);
        garageList.add(nGarage2);

        garageList = (List)nGarageEntityRepository.save(garageList);

        for(NGarage garage: garageList){
            Assert.notNull(garage.getId());
        }

    }

    @Test
    public void BcheckNGarageListTest(){
        EndResult<NGarage> garages = nGarageEntityRepository.findAll();
        Assert.notNull(garages);
        Assert.isTrue(garages.iterator().hasNext());
    }

    @Test
    public void CputCarsInGarageTest(){
        EndResult<NGarage> garages = nGarageEntityRepository.findAll();
        Assert.notNull(garages);
        Assert.isTrue(garages.iterator().hasNext());

        EndResult<NCar> cars = nCarEntityRepository.findAll();
        Assert.notNull(cars);
        Assert.isTrue(cars.iterator().hasNext());

        Iterator<NCar> nCarIterator = cars.iterator();
        int carNumber = 1;

        NGarage tmpGarageOne = garages.iterator().next();
        NGarage tmpGarageTwo = garages.iterator().next();

        List<NCar> nCarsList = new ArrayList<>();
        List<NGarage> nGarageList = new ArrayList<>();

        while(nCarIterator.hasNext()){
            NCar tmpCar = nCarIterator.next();
            if(carNumber < 4){
                tmpCar.setGarage(tmpGarageOne);
                tmpGarageOne.addCar(tmpCar);
                nCarsList.add(tmpCar);
            }else{
                tmpCar.setGarage(tmpGarageTwo);
                tmpGarageTwo.addCar(tmpCar);
                nCarsList.add(tmpCar);
            }

            carNumber++;
        }
        nGarageList.add(tmpGarageOne);
        nGarageList.add(tmpGarageTwo);

        Assert.notEmpty((List)nCarEntityRepository.save(nCarsList));
        Assert.notEmpty((List)nGarageEntityRepository.save(nGarageList));

    }

//    @Test
//    public void CdeleteNGarageListTest(){
//        EndResult<NGarage> garages = nGarageEntityRepository.findAll();
//        nGarageEntityRepository.delete(garages);
//
//        garages = nGarageEntityRepository.findAll();
//        Assert.notNull(garages);
//        Assert.isTrue(!garages.iterator().hasNext());
//    }
}
