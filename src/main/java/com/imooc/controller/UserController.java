package com.imooc.controller;

import com.imooc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dell on 2017-5-22.
 */

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;



}
