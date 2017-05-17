package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dell on 2017-5-11.
 */
//负责让类通过web方式访问
@RestController
//可以给类设置访问路径
@RequestMapping("/hello")
public class HelloController {
//   通过注解将配置文件中cupSize的属性配置于此
    @Value("${Archer}")
    private String Archer;

    @Value("${Saber}")
    private String Saber;

//    通过注解将对象配置引入
    @Autowired
    private GirlProperties girlProperties;

    //用get方式  say和watch访问路径都能作用
    @RequestMapping(value = {"/say","/watch"},method= RequestMethod.GET)
    public String say() {
//        127.0.0.1:8081/hello/say      能访问该方法
//        127.0.0.1:8081/hello/watch    能访问该方法
        return Archer+"  "+Saber+"   "+girlProperties.getCupSize();
    }

    @RequestMapping(value = {"/show/{id}","/{id}/show"},method= RequestMethod.GET)
    public String showId(@PathVariable("id") Integer id) {
//        127.0.0.1:8081/hello/show       加载失败
//        127.0.0.1:8081/hello/show/99    结果为99
//        127.0.0.1:8081/hello/11/show    结果为11
        return "id: "+id;
    }

    @RequestMapping(value = "/shoDef",method= RequestMethod.GET)
    public String showDefaultId(@RequestParam(value="id",required = false,defaultValue = "0") Integer Myid) {
//        127.0.0.1:8081/hello/shoDef?id=100 结果为100
//        127.0.0.1:8081/hello/shoDef?id=   结果为0
//        127.0.0.1:8081/hello/shoDef   结果为0
        return "id with default: "+Myid;
    }
}
