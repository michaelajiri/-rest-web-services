package com.ndf.api.controller;

import com.ndf.api.model.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3232")
@RestController
public class AuthenticationBeanController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are authenticated");
    }
}