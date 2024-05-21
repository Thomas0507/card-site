package com.site.card.site.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestCrt {

    @RequestMapping("/hello1")
    public String sayHello() {
        return "Hello 1 !!!!";
    }
    @GetMapping("/hello2")
    public String sayHello2() {
        return "Hello 2 !!!!";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/hello3")
    public String sayHello3() {
        return "Hello 3 !!!!";
    }
}
