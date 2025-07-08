package com.example.cms.Controlller;

import com.example.cms.Entity.Users;
import com.example.cms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/register")
        public ResponseEntity<Users> register(@RequestBody Users user){

            return ResponseEntity.ok(userService.register(user));
        }
    }



