package com.lim.test.jsontest;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * {@link JsonUser} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
@Slf4j
class JsonUserTest {

    @Test
    void parseObject() {
        String userStr = "{\"account\":\"test\",\"years\": 15,\"sex\":\"男\"}";
        JsonUser user = JSONObject.parseObject(userStr, JsonUser.class);
        log.info("{}", user);

        Assert.assertEquals("test", user.getName());
        Assert.assertEquals(Integer.valueOf(15), user.getAge());
        Assert.assertEquals("男", user.getSex());
    }

}