package com.lim.test.jsontest;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义映射json对象
 *
 * @author lim
 * @date 2020/10/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonUser {

    @JSONField(name = "account")
    private String name;

    @JSONField(name = "years")
    private Integer age;

    private String sex;

}
