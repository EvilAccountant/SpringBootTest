package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dell on 2017-5-12.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 返回所有girl的列表
     * @return
     */
    @GetMapping(value="/showGirls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 通过age 查找girls
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 添加一个girl
     * @return
     */
    @PostMapping(value="/addGirls")
    public Result<Girl> girlAdd(@Valid Girl girl , BindingResult bindingResult){

        //Valid 是验证注释，相当于启用Girl中的Min以及NotNull等对属性的注解，BindingResult用于返回结果信息
        if(bindingResult.hasErrors()){

            //如果错误存在，返回错误信息
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());

        }

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id 查询一个girl
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 通过id 修改一个girl
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){

        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);

    }

    /**
     * 通过id 删除一个girl
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){

        girlRepository.delete(id);
    }

    /**
     * 通过同时添加两个girl了解事务处理
     */
    @PostMapping(value = "/girls/two")
    public void addTwoGirl(){
        girlService.insertTwo();
    }

    @GetMapping(value="girls/JudgeAge/{id}")
    public void JudgeGirlAge(@PathVariable("id") Integer id) throws Exception{
        girlService.JudgeAge(id);
    }

}
