package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NCar;
import com.miko.demo.birt.util.NCarConsts;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/miko-app-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NCarEntityTest implements NCarConsts{

    private final Logger logger = LoggerFactory.getLogger(NCarEntityTest.class);

    @Autowired
    NCarEntityRepository nCarEntityRepository;

    @Test
    public void AcreateNCarTest(){

        NCar chevrolet = new NCar(NCHEVROLET, NCHEVROLET_TYPE1, NCHEVROLET_TYPE1_YEAR);
        chevrolet.setCoreName("CAR");
        NCar dodge = new NCar(NDODGE, NDODGE_TYPE1, NDODGE_TYPE1_YEAR);
        dodge.setCoreName("CAR");
        NCar ford = new NCar(NFORD, NFORD_TYPE1, NFORD_TYPE1_YEAR);
        ford.setCoreName("CAR");
        NCar skoda = new NCar(NSKODA, NSKODA_TYPE1, NSKODA_TYPE1_YEAR);
        skoda.setCoreName("CAR");
        NCar alfa = new NCar(NALFA, NALFA_TYPE1, NALFA_TYPE1_YEAR);
        alfa.setCoreName("CAR");
        NCar bmwX5 = new NCar(NBMW, NBMW_TYPE1, NBMW_TYPE1_YEAR);
        bmwX5.setCoreName("CAR");
        NCar bmwZ4 = new NCar(NBMW, NBMW_TYPE2, NBMW_TYPE2_YEAR);
        bmwZ4.setCoreName("CAR");

        List<NCar> cars = new ArrayList<>();
        cars.add(chevrolet);
        cars.add(dodge);
        cars.add(ford);
        cars.add(skoda);
        cars.add(alfa);
        cars.add(bmwX5);
        cars.add(bmwZ4);

        cars = (List)nCarEntityRepository.save(cars);
        for(NCar car: cars){
            Assert.notNull(car.getId());
        }

    }

    @Test
    public void BcheckNCarTest(){
        List<NCar> skodas = nCarEntityRepository.findByMake(NSKODA);
        Assert.notNull(skodas);
        Assert.notEmpty(skodas);

        Assert.isTrue(skodas.get(0).getMake().equals(NSKODA));

    }
//
//    @Test
//    public void CdeleteNCarListTest(){
//        EndResult<NCar> cars = nCarEntityRepository.findAll();
//        Assert.notNull(cars);
//
//        nCarEntityRepository.delete(cars);
//
//        cars = nCarEntityRepository.findAll();
//        Assert.isTrue(!cars.iterator().hasNext());
//    }



}
