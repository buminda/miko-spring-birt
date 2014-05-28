package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NCar;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */
public interface NCarEntityRepository extends GraphRepository<NCar> {

    NCar findOne(Long id);

    @Query("MATCH (ncar:NCar) WHERE ncar.make = 'Ford' return ncar")
    NCar findByMakeFord();

    List<NCar> findByMake(String make);

    List<NCar> findByModel(String model);

    List<NCar> findByYear(String year);

    <C extends NCar> C save(C nCar);

}
