package com.lim.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lim
 * @since 2021/1/22
 */
@Slf4j
public class ThreadExtend extends Thread {

    private final String tag;

    public ThreadExtend(String tag) {
        this.tag = tag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("tag: {}", tag);
    }

}
