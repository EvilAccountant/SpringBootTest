package com.imooc.service;

import com.imooc.GirlApplicationTests;
import com.imooc.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringRunner.class)
////表示在测试环境下运行
//@SpringBootTest
////表示运行整个SpringBoot

//继承ApplicationTests则不需要以上两个注解
public class GirlServiceTest extends GirlApplicationTests {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl=girlService.findOne(10);//获取对象
        Assert.assertEquals(new Integer(28),girl.getAge());//将对象的age与输入值进行比对

    }

}