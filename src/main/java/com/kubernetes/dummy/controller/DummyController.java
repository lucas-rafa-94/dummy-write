package com.kubernetes.dummy.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;



@RestController
@RequestMapping("/dummy")
public class DummyController {

    Logger logger = LoggerFactory.getLogger(DummyController.class);

    @PostMapping
    public int soma(@RequestParam int num1, @RequestParam int num2 ){
        logger.debug("Requisicao aceita...");
        int result = num1+num2;
        try {
            Files.write(Paths.get("/app/data/outout" + num1 + num2 + ".txt"), Integer.toString(result).getBytes());
            logger.debug("Escrita aqrquivo " + "/app/data/outout" + num1 + num2 + ".txt");
        }catch (Exception e){
            e.printStackTrace();
        }
        return num1 + num2;
    }
}
