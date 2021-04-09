package com.lim.test.localdatetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author lim
 * @since 2021/2/1
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        LocalDate l0 = LocalDate.parse("2019-12-31");
        LocalDate l1 = LocalDate.parse("2021-01-01");
        LocalDate l2 = LocalDate.parse("2021-01-02");
        LocalDate l3 = LocalDate.parse("2021-01-03");
        LocalDate l4 = LocalDate.parse("2021-01-04");
        LocalDate l5 = LocalDate.parse("2020-01-05");
        LocalDate l6 = LocalDate.parse("2020-01-06");

        System.out.println(l0.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(l1.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(l2.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(l3.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(l4.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(l5.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(l6.format(DateTimeFormatter.ISO_WEEK_DATE));

//        yyyyYYYY();
//        centry();
    }

    public static void yyyyYYYY() {
        LocalDate localDate = LocalDate.parse("2020-12-31");
        log.info("date: {}, yyyy: {}, YYYY: {}", localDate,
                localDate.format(DateTimeFormatter.ofPattern("yyyy")),
                localDate.format(DateTimeFormatter.ofPattern("YYYY")));
    }

    public static void centry() {
        LocalDate localDate = LocalDate.parse("2020-12-31");
        log.info("date:{}, CCYY: {}", localDate, localDate.format(DateTimeFormatter.ofPattern("CCyy")));
    }
}
