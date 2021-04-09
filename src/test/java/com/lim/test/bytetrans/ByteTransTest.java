package com.lim.test.bytetrans;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author lim

 * @since 2021/3/17
 */
@Slf4j
class ByteTransTest {

    @Test
    void byte2String() {
        byte[] b = new byte[] {36, 2, 3, -12, -128, -112, 72, 87, 0, 0};
        System.out.println(ByteTrans.byte2String(b));
    }

    @Test
    void short2byte() {
        byte[] b = new byte[] {2, 3};

    }

    @Test
    void byte2short() {
    }

    @Test
    void int2byte() {
    }

    @Test
    void byte2int() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}