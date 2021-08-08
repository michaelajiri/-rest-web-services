package com.ndf.api.controller;

import com.ndf.api.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3232")
@RestController
public class HomeController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
//        throw new RuntimeException("Some Error happened! Contact Support at ***-***");
        return new HelloWorldBean("Hello World - Changed");
    }
    
    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World! %s", name));
    }
}