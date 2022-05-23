package com.sap.ideationportal.controller;

import com.sap.ideationportal.entities.User;
import com.sap.ideationportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/{id}/topics")
    public void subscribeTopic(@RequestBody User user, @PathVariable Long id) {
        this.userService.subscribeTopic(user);
    }

}
