package com.lim.test.jsontest;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link JsonUser} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
@Slf4j
class JsonUserTest {

    /**
     * 字符串预处理后再json反序列化
     */
    @Test
    void parseObjectOfWrongStr() {
        String userStr = "{\"account\":\"test\",\"years\": 15,\"sex\":\"男\"}aaa";
        log.info("before modify length: {}", userStr.length());

        String endStr = "}";
        int lastIndex = userStr.lastIndexOf(endStr);
        userStr = userStr.substring(0, lastIndex + endStr.length());
        log.info("after modify: {}, lastIndex: {}", userStr, lastIndex);

        JsonUser user = JSONObject.parseObject(userStr, JsonUser.class);
        log.info("{}", user);
        Assertions.assertEquals("test", user.getName());
    }

    /**
     * json字符串反序列化为java bean
     */
    @Test
    void parseObject() {
        String userStr = "{\"account\":\"test\",\"years\": 15,\"sex\":\"男\"}";
        JsonUser user = JSONObject.parseObject(userStr, JsonUser.class);
        log.info("{}", user);

        Assertions.assertEquals("test", user.getName());
        Assertions.assertEquals(Integer.valueOf(15), user.getAge());
        Assertions.assertEquals("男", user.getSex());
    }

}