package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NCar;
import com.miko.demo.birt.model.NGarage;
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
public class NCarAndNGarageCleanTest {

    private final Logger logger = LoggerFactory.getLogger(NCarEntityTest.class);

    @Autowired
    NCarEntityRepository nCarEntityRepository;

    @Autowired
    NGarageEntityRepository nGarageEntityRepository;


    @Test
    public void AdeleteNGarageListTest(){
        EndResult<NGarage> garages = nGarageEntityRepository.findAll();
        nGarageEntityRepository.delete(garages);

        garages = nGarageEntityRepository.findAll();
        Assert.notNull(garages);
        Assert.isTrue(!garages.iterator().hasNext());
    }


    @Test
    public void BdeleteNCarListTest(){
        EndResult<NCar> cars = nCarEntityRepository.findAll();
        Assert.notNull(cars);

        nCarEntityRepository.delete(cars);

        cars = nCarEntityRepository.findAll();
        Assert.isTrue(!cars.iterator().hasNext());
    }

}
