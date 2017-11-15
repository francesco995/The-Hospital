package com.objectway.stage.controller;


import com.objectway.stage.model.Physician;
import com.objectway.stage.service.PhysicianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class PhysicianController {

    private static final Logger logger = LoggerFactory.getLogger(PhysicianController.class);

    @Autowired
    PhysicianService physicianService;


    @RequestMapping(value = "/getAllPhysicians", method = RequestMethod.GET)
    @ResponseBody
    public String getAllPhysicians(Model model) {

        logger.info("Entering getAllPhysicians Controller");

        Set<Physician> physicians = physicianService.getAllPhysicians();

        String string = physicians.toString();

        return string;
    }


}
