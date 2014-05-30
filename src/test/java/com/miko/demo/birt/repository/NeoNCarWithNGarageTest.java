package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NCar;
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
 * Date: 5/30/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/miko-app-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NeoNCarWithNGarageTest implements NCarConsts, NGarageConsts {

    private final Logger logger = LoggerFactory.getLogger(NeoCarInGarageTest.class);

    @Autowired
    NCarEntityRepository nCarEntityRepository;

    @Autowired
    NGarageEntityRepository nGarageEntityRepository;

    @Autowired
    NeoCarService neoCarService;

    @Autowired
    NeoGarageService neoGarageService;

    @Test
    public void getNCarWithNGarageTest(){
        NCar carFord = neoCarService.findByMakeForWithGarage();
        Assert.notNull(carFord);
        Assert.isTrue(carFord.getMake().equals(NFORD));

        Assert.isTrue(carFord.getGarage().getName().equals(NGARAGE_ONE));
        Assert.isTrue(!carFord.getGarage().getName().equals(NGARAGE_TWO));
    }

    @Test
    public void getNCarByMakeSimplePropertiesTest(){
        NCar skoda = nCarEntityRepository.findByMake(NSKODA).get(0);
        Assert.notNull(skoda);
        Assert.isTrue(skoda.getMake().equals(NSKODA));

        Assert.isTrue(skoda.getGarage().getCoreName().equals(NGARAGE_CORE_NAME));

    }

    @Test
    public void getNCarNumberInGarageByName(){
        int garageOneCarNumber = neoGarageService.getCarNumberByName(NGARAGE_ONE);
        Assert.isTrue(garageOneCarNumber == 3);
    }
}
