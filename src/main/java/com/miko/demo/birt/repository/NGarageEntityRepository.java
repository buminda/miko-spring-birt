package com.miko.demo.birt.repository;

import com.miko.demo.birt.model.NGarage;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */
public interface NGarageEntityRepository extends GraphRepository<NGarage> {

    NGarage findOne(Long id);

    List<NGarage> findByName(String name);

    <C extends NGarage> C save(C nGarage);
}


