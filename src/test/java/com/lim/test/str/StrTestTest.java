package com.lim.test.str;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link StrTest} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
@Slf4j
class StrTestTest {

    @Test
    public void null2String() {
        Integer a = null;
        // b对象不为null，字符串值为"null"
        String b = String.valueOf(a);
        log.info("{}", b);
        Assertions.assertEquals("null", b);
    }

}