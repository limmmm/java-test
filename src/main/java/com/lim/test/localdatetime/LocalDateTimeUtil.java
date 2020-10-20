package com.lim.test.localdatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * LocalDataTime 操作辅助
 *
 * @author lim
 * @date 2020/1/29
 */
public class LocalDateTimeUtil {

    /**
     * LocalDateTime 转为 毫秒数
     * WARN: 使用系统默认时区
     */
    public static long localDateTime2Mills(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTime 转为 秒数
     * WARN: 使用系统默认时区
     */
    public static long localDateTime2Seconds(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    /**
     * 毫秒数 转为 LocalDateTime
     * WARN: 使用系统默认时区
     */
    public static LocalDateTime mills2LocalDateTime(long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault());
    }

    /**
     * 秒数 转为 LocalDateTime
     * WARN: 使用系统默认时区
     */
    public static LocalDateTime seconds2LocalDateTime(long seconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
    }

    /**
     * 是否包含今天
     *
     * @param start 开始时间
     * @param end 结束时间
     * @return
     *      true：包含
     *      false: 不包含
     */
    public static boolean containsToday(LocalDateTime start, LocalDateTime end) {
        if(start == null || end == null) {
            return false;
        }

        LocalDate sd = start.toLocalDate();
        LocalDate ed = end.toLocalDate();

        LocalDate now = LocalDate.now();

        return sd.isEqual(now) || ed.isEqual(now) || (sd.isBefore(now) && now.isBefore(ed));
    }

}
