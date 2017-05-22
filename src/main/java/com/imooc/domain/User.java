package com.imooc.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Dell on 2017-5-22.
 */


@Entity
//实现属性映射数据库字段
@Table(name="user_table")
public class User {

    @Id
    @GenericGenerator(name="userIdGen", strategy="uuid") //生成32位UUID
    @GeneratedValue(generator="userIdGen")
    @Column(name = "id",length = 32,nullable = false)
    private String userId;

    /**
     * 帐号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 电子邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 出生日期
     */
    @Column(name = "user_birth")
    private String userBirth;

    /**
     * 性别
     */
    @Column(name = "user_gender")
    private String userGender;

    /**
     * 名称
     */
    @Column(name = "user_name")
    private String userName;

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
