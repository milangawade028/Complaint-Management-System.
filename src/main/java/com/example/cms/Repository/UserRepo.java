package com.example.cms.Repository;

import com.example.cms.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {


    Users findByUserName(String username);
}
