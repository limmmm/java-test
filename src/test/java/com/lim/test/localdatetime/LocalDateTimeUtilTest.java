package com.lim.test.localdatetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * {@link LocalDateTimeUtil} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
@Slf4j
class LocalDateTimeUtilTest {

    @Test
    void localDateTime2Mills() {
        // 2020-10-11 12:13:14.123
        LocalDateTime ldt = LocalDateTime.of(2020, 10, 11, 12, 13, 14, 123000000);
        long rs = LocalDateTimeUtil.localDateTime2Mills(ldt);
        log.info("时间：{}, 毫秒时间戳：{}", ldt, rs);
        Assert.assertEquals(1602389594123L, rs);
    }

    @Test
    void localDateTime2Seconds() {
        // 2020-10-11 12:13:14.123
        LocalDateTime ldt = LocalDateTime.of(2020, 10, 11, 12, 13, 14, 123000000);
        long rs = LocalDateTimeUtil.localDateTime2Seconds(ldt);
        log.info("时间：{}, 秒时间戳：{}", ldt, rs);
        Assert.assertEquals(1602389594L, rs);
    }

    @Test
    void mills2LocalDateTime() {
        long mills = 1602389594123L;
        LocalDateTime rs = LocalDateTimeUtil.mills2LocalDateTime(mills);
        log.info("毫秒时间戳：{}, 时间：{}", mills, rs);
        LocalDateTime ldt = LocalDateTime.of(2020, 10, 11, 12, 13, 14, 123000000);
        Assert.assertEquals(ldt, rs);
    }

    @Test
    void seconds2LocalDateTime() {
        long seconds = 1602389594L;
        LocalDateTime rs = LocalDateTimeUtil.seconds2LocalDateTime(seconds);
        log.info("秒时间戳：{}, 时间：{}", seconds, rs);
        LocalDateTime ldt = LocalDateTime.of(2020, 10, 11, 12, 13, 14, 0);
        Assert.assertEquals(ldt, rs);
    }

    @Test
    void containsToday() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now().plusDays(1);
        boolean rs = LocalDateTimeUtil.containsToday(start, end);
        log.info("start：{}, end：{}, containsToday：{}", start, end, rs);
        Assert.assertTrue(rs);
    }

}