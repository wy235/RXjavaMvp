package com.example.rxjavademo.main.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者:wangyu
 * 创建时间:2019/12/3 15:52
 * 描述:
 */
@Entity
public class Student {

    private String name;

    @Generated(hash = 1699057470)
    public Student(String name) {
        this.name = name;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
