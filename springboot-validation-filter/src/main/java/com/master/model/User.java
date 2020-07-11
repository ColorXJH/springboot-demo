package com.master.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/10 9:15
 */

public class User {
    @NotEmpty(message = "性名不能为空")
    private String name;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @Max(value =100,message = "年龄不能大于100岁")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
