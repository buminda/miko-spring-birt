package com.miko.demo.birt.controller;

import com.miko.demo.birt.core.BirtEngineFactory;
import com.miko.demo.birt.core.BirtView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/23/14
 *
 * BirtView is used to run and render BIRT reports
 *
 */
@Controller
@RequestMapping("/reports")
public class BirtController implements ApplicationContextAware {


    private final Logger logger = LoggerFactory.getLogger(BirtController.class);


    private ApplicationContext context ;

    @RequestMapping(method = RequestMethod.GET)
    public BirtView testRequest(HttpServletRequest request, HttpServletResponse response){

        logger.debug("BIRT response");

        return birtView();
    }

    @Bean
    public BirtView birtView(){

        logger.debug("birtView START");

        BirtView bv = new BirtView();
        bv.setReportFormatRequestParameter("ReportFormat");
        bv.setBirtEngine(engine().getObject());
        return bv;
    }

    @Bean
    protected BirtEngineFactory engine(){
        BirtEngineFactory factory = new BirtEngineFactory() ;
        factory.setApplicationContext(context);

        logger.debug("Birt Factor CALLED");

        return factory ;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        context = ctx;
    }
}
