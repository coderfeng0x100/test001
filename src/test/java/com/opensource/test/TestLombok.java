package com.opensource.test;

import com.opensource.entity.UserEntity;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
public class TestLombok {

    public static void main(String[] args) {

        UserEntity ue = new UserEntity();
        ue.setName("lili");
        ue.setAge(29);

        System.out.println(ue.getName() + ":" + ue.getAge());
    }
}
