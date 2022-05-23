package com.sap.ideationportal.dao;

import com.sap.ideationportal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

}
