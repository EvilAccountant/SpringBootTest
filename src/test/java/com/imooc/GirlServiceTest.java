package com.imooc;

import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/**
 * Created by Dell on 2017-5-18.
 */
//@RunWith(SpringRunner.class)
////表示在测试环境下运行
//@SpringBootTest
////表示运行整个SpringBoot

//继承ApplicationTests则不需要以上两个注解
public class GirlServiceTest extends GirlApplicationTests{

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl=girlService.findOne(10);//获取对象
        Assert.assertEquals(new Integer(14),girl.getAge());//将对象的age与输入值进行比对

    }

}
