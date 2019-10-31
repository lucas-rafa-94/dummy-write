package com.kubernetes.dummy.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@RestController
@RequestMapping("/dummy")
public class DummyController {

    Logger logger = LoggerFactory.getLogger(DummyController.class);

    @GetMapping
    public int getNumeroFiles(){
        logger.debug("Requisicao aceita...");
        int result = 0;
        try {
            File directory= new File("/app/data");
            result = directory.list().length;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
