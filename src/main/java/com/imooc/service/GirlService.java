package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dell on 2017-5-12.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    //事务注解，当方法中一条运行出错，则整个方法最后都不执行（回滚）
    @Transactional
    public void insertTwo(){

        Girl girlA=new Girl();
        girlA.setAge(9);
        girlA.setCupSize("D");
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setAge(998);
        girlB.setCupSize("DNF");//超出字段限制长度，使GirlB插入失败
        girlRepository.save(girlB);
    }


    public void JudgeAge(Integer id) throws Exception{
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<=18){
            //返回 Too small
            throw new GirlException(100,"Too small");
        }else if(age>18&&age<27){
            //返回 Not big enough
            throw new GirlException(101,"Big enough");
        }
    }
}
