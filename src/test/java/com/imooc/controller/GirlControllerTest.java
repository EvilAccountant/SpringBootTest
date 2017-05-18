package com.imooc.controller;

import com.imooc.GirlApplicationTests;
import com.imooc.service.GirlService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by Dell on 2017-5-18.
 */
@AutoConfigureMockMvc
public class GirlControllerTest extends GirlApplicationTests{

    @Autowired
    private MockMvc mvc;



    @Test
    public void girlList() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/showGirls")).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("abc"));

    }

}