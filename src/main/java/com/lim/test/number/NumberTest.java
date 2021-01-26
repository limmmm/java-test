package com.lim.test.number;

import lombok.extern.slf4j.Slf4j;

/**
 * 基础类型 ==、equalse测试
 * WARN:
 *  1. Long 和 Integer -127 ~ 128 使用==判断时为true
 *  2. new Long、new Integer会不使用JVM中的对象，不能使用==判断
 * @author lim
 * @since 2021/1/26
 */
@Slf4j
public class NumberTest {

    public static void intTest1() {
        int a = 1;
        Integer b = 1;

        // true
        log.info("int a == Integer b ? {}", a == b);

        // true
        log.info("Integer b == int a ? {}", b == a);

        // true
        log.info("Integer b equals int a ? {}", b.equals(a));
    }

    public static void intTest128() {
        int a = 128;
        Integer b = 128;

        // true
        log.info("int a == Integer b ? {}", a == b);

        // true
        log.info("Integer b == int a ? {}", b == a);

        // true
        log.info("Integer b equals int a ? {}", b.equals(a));
    }

    public static void integerTest1() {
        Integer a = 1;
        Integer b = 1;

        // true
        log.info("Integer a == Integer b ? {}", a == b);

        // true
        log.info("Integer b == Integer a ? {}", b == a);

        // true
        log.info("Integer a equals Integer b ? {}", a.equals(b));

    }

    public static void integerTest128() {
        Integer a = 128;
        Integer b = 128;

        // false
        log.info("Integer a == Integer b ? {}", a == b);

        // false
        log.info("Integer b == Integer a ? {}", b == a);

        // true
        log.info("Integer a equals Integer b ? {}", a.equals(b));
    }

    public static void longTest1() {
        long a = 1L;
        Long b = 1L;

        // true
        log.info("long a == Long b ? {}", a == b);

        // true
        log.info("Long b == long a ? {}", b == a);

        // true
        log.info("Long b equals long a ? {}", b.equals(a));
    }

    public static void longTest128() {
        long a = 128L;
        Long b = 128L;

        // true
        log.info("long a == Long b ? {}", a == b);

        // true
        log.info("Long b == long a ? {}", b == a);

        // true
        log.info("Long b equals long a ? {}", b.equals(a));
    }

    public static void longBoxTest1() {
        Long a = 1L;
        Long b = 1L;

        // true
        log.info("Long a == Long b ? {}", a == b);

        // true
        log.info("Long b == Long a ? {}", b == a);

        // true
        log.info("Long b equals Long a ? {}", b.equals(a));
    }

    public static void longBoxTest128() {
        Long a = 127L;
        Long b = 127L;

        // false
        log.info("Long a == Long b ? {}", a == b);

        // false
        log.info("Long b == Long a ? {}", b == a);

        // true
        log.info("Long b equals Long a ? {}", b.equals(a));
    }

    public static void longBoxNewTest127() {
        Long a = 127L;
        Long b = 127L;
        Long c = new Long(127L);

        // true
        log.info("Long a == Long b ? {}", a == b);
        // false
        log.info("Long a == new Long c ? {}", a == c);

        // true
        log.info("Long b == Long a ? {}", b == a);
        // false
        log.info("new Long c == Long a ? {}", c == a);

        // true
        log.info("Long b equals Long a ? {}", b.equals(a));
        // true
        log.info("new Long c equals Long a ? {}", c.equals(a));
    }

}
