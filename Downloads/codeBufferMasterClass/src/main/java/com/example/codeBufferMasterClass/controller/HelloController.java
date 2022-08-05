package com.example.codeBufferMasterClass.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //this is used for get the data form application property file this is the best example for How to add config
    @Value("${welcome.message}")
    private String welcomeMessage;

        //we also use @RequestMapping(value = "hello", method = RequestMethod.GET)
        @GetMapping()
        public String helloWorld(){

            // just for simple print on web
//            return "welcome to code buffer";
            return welcomeMessage;
        }
    }



