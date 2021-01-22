package com.lim.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程操作测试
 *
 * @author lim
 * @date 2020/4/4
 */
@Slf4j
public class ThreadTest {

    public static void join() throws InterruptedException {
        // t
        Thread t = new Thread(() -> {
            log.info("{}", "t线程开始让出cpu");
            Thread.yield();
            log.info("{}", "t线程执行完成");
        });

        // t1
        Thread t1 =new Thread(() -> {
            log.info("{}", "t1线程开始让出cpu");
            Thread.yield();
            log.info("{}", "t1线程执行完成");
        });

        t.start();
        t1.start();
        t.join();
        t1.join();
    }

}
