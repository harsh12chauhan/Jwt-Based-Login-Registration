package com.jwt_login_register.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/user/home")
    public String userHome() {
        return "Welcome to User Home!";
    }

    @GetMapping("/api/admin/home")
    public String adminHome() {
        return "Welcome to Admin Home!";
    }
}
