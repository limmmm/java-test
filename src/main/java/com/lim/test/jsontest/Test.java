package com.lim.test.jsontest;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Ming
 * @mail liming@tp-link.com.cn
 * @since 2021/4/1
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        String a = "{\"type\":\"notification\", \"seq\":2, \"params\":{\"event_type\":\"ai_config_change\", \"reason\":\"ai_config_change\"}}aaaa\n";
        int i = a.lastIndexOf("}}");
        log.info("i: {}", i);
        a = a.substring(0, i + 2);
        log.info(a.substring(0, i + 2));
        JSONObject jsonObject = JSONObject.parseObject(a);
        log.info("{}", jsonObject);

        List<String> s = new ArrayList<>();


        if (a && b) else if (c) else if (a! && !c && b)
    }
}
