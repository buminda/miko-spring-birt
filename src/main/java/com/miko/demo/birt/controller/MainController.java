package com.miko.demo.birt.controller;

import com.miko.demo.birt.service.FakeCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/23/14
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    FakeCarService fakeCarService;


    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome to the BIRT Example App (spring, neo4j)");
        model.addAttribute("cars",  fakeCarService.getAllCars());

        return "hello";
    }

}
