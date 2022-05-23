package com.sap.ideationportal.services;

import com.sap.ideationportal.dao.UserDao;
import com.sap.ideationportal.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void subscribeTopic(User user) {
     userDao.save(user);
    }
}
