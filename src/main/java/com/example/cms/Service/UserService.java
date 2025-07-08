package com.example.cms.Service;

import com.example.cms.Entity.Users;
import com.example.cms.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


    @Service
    public class UserService {

        @Autowired
        private UserRepo usersRepo;
        private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        public Users register(Users user) {
            user.setPassword(encoder.encode(user.getPassword()));
            Users save = usersRepo.save(user);
            return save;
        }
    }

