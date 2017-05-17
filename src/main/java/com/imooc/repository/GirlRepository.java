package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dell on 2017-5-12.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

//通过年龄查询
    public List<Girl> findByAge(Integer age);

}
