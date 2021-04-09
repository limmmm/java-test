package com.lim.test.localdate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * {@link LocalDateUtil} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
@Slf4j
class LocalDateUtilTest {

    @Test
    void getStartOfWeek() {
        LocalDate date = LocalDate.parse("2020-10-20");
        LocalDate rs = LocalDateUtil.getStartOfWeek(date);
        log.info("日期：{}，周开始：{}", date, rs);
        Assertions.assertEquals(LocalDate.parse("2020-10-18"), rs);
    }

    @Test
    void getEndOfWeek() {
        LocalDate date = LocalDate.parse("2020-10-20");
        LocalDate rs = LocalDateUtil.getEndOfWeek(date);
        log.info("日期：{}，周结束：{}", date, rs);
        Assertions.assertEquals(LocalDate.parse("2020-10-24"), rs);
    }

    @Test
    void getBeforeWeek() {
        LocalDate date = LocalDate.parse("2020-10-20");
        LocalDate rs = LocalDateUtil.getBeforeWeek(date);
        log.info("日期：{}, 一周前：{}", date, rs);
        Assertions.assertEquals(LocalDate.parse("2020-10-13"), rs);
    }

    @Test
    void getStartOfMonth() {
        LocalDate date = LocalDate.parse("2020-10-20");
        LocalDate rs = LocalDateUtil.getStartOfMonth(date);
        log.info("日期：{}, 月开始：{}", date, rs);
        Assertions.assertEquals(LocalDate.parse("2020-10-01"), rs);
    }

    @Test
    void getEndOfMonth() {
        LocalDate date = LocalDate.parse("2020-10-20");
        LocalDate rs = LocalDateUtil.getEndOfMonth(date);
        log.info("日期：{}, 月结束：{}", date, rs);
        Assertions.assertEquals(LocalDate.parse("2020-10-31"), rs);
    }

    @Test
    void getBeforeMonth() {
        LocalDate ld1 = LocalDate.parse("2020-12-18");
        LocalDate ld2 = LocalDate.parse("2020-12-31");
        LocalDate ld3 = LocalDate.parse("2020-11-30");
        LocalDate ld4 = LocalDate.parse("2020-11-30");

        LocalDate rs1 = LocalDateUtil.getBeforeMonth(true, ld1);
        LocalDate rs2 = LocalDateUtil.getBeforeMonth(true, ld2);
        LocalDate rs3 = LocalDateUtil.getBeforeMonth(true, ld3);
        LocalDate rs4 = LocalDateUtil.getBeforeMonth(false, ld4);

        log.info("日期：{}，一月前：{}", ld1, rs1);
        log.info("日期：{}，一月前：{}", ld2, rs2);
        log.info("日期：{}，一月前：{}", ld3, rs3);
        log.info("日期：{}，一月前：{}", ld4, rs4);

        Assertions.assertEquals(LocalDate.parse("2020-11-18"), rs1);
        Assertions.assertEquals(LocalDate.parse("2020-11-30"), rs2);
        Assertions.assertEquals(LocalDate.parse("2020-10-31"), rs3);
        Assertions.assertEquals(LocalDate.parse("2020-10-30"), rs4);
    }

    @Test
    void getWeekOfYear() {
        // 跨周
        LocalDate ld1 = LocalDate.parse("2020-10-10");
        LocalDate ld2 = LocalDate.parse("2020-10-11");
        LocalDate ld3 = LocalDate.parse("2020-10-17");
        LocalDate ld4 = LocalDate.parse("2020-10-18");
        String rs1 = LocalDateUtil.getWeekOfYear(ld1);
        String rs2 = LocalDateUtil.getWeekOfYear(ld2);
        String rs3 = LocalDateUtil.getWeekOfYear(ld3);
        String rs4 = LocalDateUtil.getWeekOfYear(ld4);

        printWeek(ld1, rs1);
        printWeek(ld2, rs2);
        printWeek(ld3, rs3);
        printWeek(ld4, rs4);
        Assertions.assertEquals("2020#41", rs1);
        Assertions.assertEquals("2020#42", rs2);
        Assertions.assertEquals("2020#42", rs3);
        Assertions.assertEquals("2020#43", rs4);

        System.out.println();

        // 跨年
        LocalDate ld5 = LocalDate.parse("2019-12-29");
        LocalDate ld6 = LocalDate.parse("2019-12-31");
        LocalDate ld7 = LocalDate.parse("2020-01-01");
        LocalDate ld8 = LocalDate.parse("2020-01-04");
        String rs5 = LocalDateUtil.getWeekOfYear(ld5);
        String rs6 = LocalDateUtil.getWeekOfYear(ld6);
        String rs7 = LocalDateUtil.getWeekOfYear(ld7);
        String rs8 = LocalDateUtil.getWeekOfYear(ld8);

        printWeek(ld5, rs5);
        printWeek(ld6, rs6);
        printWeek(ld7, rs7);
        printWeek(ld8, rs8);
        Assertions.assertEquals("2020#1", rs5);
        Assertions.assertEquals("2020#1", rs6);
        Assertions.assertEquals("2020#1", rs7);
        Assertions.assertEquals("2020#1", rs8);
    }

    @Test
    void getWeekOfMonth() {
        LocalDate ld1 = LocalDate.parse("2020-10-03");
        LocalDate ld2 = LocalDate.parse("2020-10-04");
        LocalDate ld3 = LocalDate.parse("2020-10-05");
        LocalDate ld4 = LocalDate.parse("2020-10-06");
        String rs1 = LocalDateUtil.getWeekOfMonth(ld1);
        String rs2 = LocalDateUtil.getWeekOfMonth(ld2);
        String rs3 = LocalDateUtil.getWeekOfMonth(ld3);
        String rs4 = LocalDateUtil.getWeekOfMonth(ld4);

        printWeek(ld1, rs1);
        printWeek(ld2, rs2);
        printWeek(ld3, rs3);
        printWeek(ld4, rs4);
        Assertions.assertEquals("2020-10#1", rs1);
        Assertions.assertEquals("2020-10#1", rs2);
        Assertions.assertEquals("2020-10#1", rs3);
        Assertions.assertEquals("2020-10#1", rs4);
    }

    @Test
    void getWeekOfMonthSeven() {
        LocalDate ld1 = LocalDate.parse("2020-10-03");
        LocalDate ld2 = LocalDate.parse("2020-10-04");
        LocalDate ld3 = LocalDate.parse("2020-10-05");
        LocalDate ld4 = LocalDate.parse("2020-10-06");
        String rs1 = LocalDateUtil.getWeekOfMonthSeven(ld1);
        String rs2 = LocalDateUtil.getWeekOfMonthSeven(ld2);
        String rs3 = LocalDateUtil.getWeekOfMonthSeven(ld3);
        String rs4 = LocalDateUtil.getWeekOfMonthSeven(ld4);

        printWeek(ld1, rs1);
        printWeek(ld2, rs2);
        printWeek(ld3, rs3);
        printWeek(ld4, rs4);
        Assertions.assertEquals("2020-09#4", rs1);
        Assertions.assertEquals("2020-10#1", rs2);
        Assertions.assertEquals("2020-10#1", rs3);
        Assertions.assertEquals("2020-10#1", rs4);
    }

    @Test
    void getMonthOfYear() {
        LocalDate ld1 = LocalDate.parse("2020-10-03");
        LocalDate ld2 = LocalDate.parse("2020-10-31");
        LocalDate ld3 = LocalDate.parse("2020-11-05");
        LocalDate ld4 = LocalDate.parse("2020-12-06");
        String rs1 = LocalDateUtil.getMonthOfYear(ld1);
        String rs2 = LocalDateUtil.getMonthOfYear(ld2);
        String rs3 = LocalDateUtil.getMonthOfYear(ld3);
        String rs4 = LocalDateUtil.getMonthOfYear(ld4);

        log.info("日期：{}, 月份：{}", ld1, rs1);
        log.info("日期：{}, 月份：{}", ld2, rs2);
        log.info("日期：{}, 月份：{}", ld3, rs3);
        log.info("日期：{}, 月份：{}", ld4, rs4);
        Assertions.assertEquals("2020-10", rs1);
        Assertions.assertEquals("2020-10", rs2);
        Assertions.assertEquals("2020-11", rs3);
        Assertions.assertEquals("2020-12", rs4);
    }

    @Test
    void getYear() {
        LocalDate ld1 = LocalDate.parse("2019-10-03");
        LocalDate ld2 = LocalDate.parse("2020-10-04");
        LocalDate ld3 = LocalDate.parse("2019-11-05");
        LocalDate ld4 = LocalDate.parse("2020-12-06");
        String rs1 = LocalDateUtil.getYear(ld1);
        String rs2 = LocalDateUtil.getYear(ld2);
        String rs3 = LocalDateUtil.getYear(ld3);
        String rs4 = LocalDateUtil.getYear(ld4);

        log.info("日期：{}, 年份：{}", ld1, rs1);
        log.info("日期：{}, 年份：{}", ld2, rs2);
        log.info("日期：{}, 年份：{}", ld3, rs3);
        log.info("日期：{}, 年份：{}", ld4, rs4);
        Assertions.assertEquals("2019", rs1);
        Assertions.assertEquals("2020", rs2);
        Assertions.assertEquals("2019", rs3);
        Assertions.assertEquals("2020", rs4);
    }

    private static void printWeek(LocalDate date, String week) {
        log.info("日期：{}, 星期：{}，第几周：{}", date, date.getDayOfWeek(), week);
    }
}