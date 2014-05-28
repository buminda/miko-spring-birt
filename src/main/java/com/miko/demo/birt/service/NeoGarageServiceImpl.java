package com.miko.demo.birt.service;

import com.miko.demo.birt.model.NGarage;
import com.miko.demo.birt.repository.NGarageEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */

@Service("neoGarageService")
public class NeoGarageServiceImpl implements NeoGarageService {

    private final Logger logger = LoggerFactory.getLogger(NeoGarageServiceImpl.class);

    @Autowired
    NGarageEntityRepository nGarageEntityRepository;

    @Override
    public NGarage findByName(String name) {

        List<NGarage> garages = nGarageEntityRepository.findByName(name);

        return garages.isEmpty() ? null : garages.get(0);
    }
}
