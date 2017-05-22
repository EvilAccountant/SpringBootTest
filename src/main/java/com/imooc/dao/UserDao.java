package com.imooc.dao;

import com.imooc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dell on 2017-5-22.
 */
public interface UserDao extends JpaRepository<User,Integer> {

    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    List<User> findByUserName(String userName);

    /**
     * 通过电子邮箱查找
     * @param userEmail
     * @return
     */
    List<User> findByUserEmail(String userEmail);

    /**
     * 通过性别查找
     * @param userGender
     * @return
     */
    List<User> findByUserGender(String userGender);

    /**
     * 通过帐号和电子邮箱找回
     * @param userAccount
     * @param userEmail
     * @return
     */
    List<User> findByUserAccountAndUserEmail(String userAccount,String userEmail);




}
