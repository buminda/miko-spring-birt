package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NGarage;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */
public interface NGarageEntityRepository extends GraphRepository<NGarage> {

    NGarage findOne(Long id);

    List<NGarage> findByName(String name);

    @Query("MATCH (g:NGarage)-->(nCar: NCar)-->(g_of_nCar) WHERE g.name = {name} RETURN count(g_of_nCar)")
    int getCarNumberByName(@Param("name") String name);

    <C extends NGarage> C save(C nGarage);
}


