package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Dell on 2017-5-12.
 */
@Entity
//实现属性映射数据库字段
public class Girl {
    @Id
    @GeneratedValue//自增Integer
    private Integer id;

    @NotNull(message = "We need more cup")
    private String cupSize;

    //给age设置最小值10,当验证结果不符时输出message当中的内容
    @Min(value = 18 , message = "The Deep Dark Fantasy")
    private Integer age;

    //NotNull不为空注解
    @NotNull(message = "We need more gold")
    private Double money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
