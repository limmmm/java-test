package com.lim.test.hashtest;

import lombok.Data;

/**
 * {@code @Data}会重写 hashcode/equals 算法，属性值相同，hashcode相等
 *
 * @author lim
 * @date 2020/6/8
 */
@Data
class HashUser {

    private String id;

    private String name;

    private Integer age;

    public HashUser(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
