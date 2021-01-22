package com.lim.test.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lim
 * @since 2021/1/22
 */
@Slf4j
public class ThreadImpl implements Runnable {

    private final String tag;

    public ThreadImpl(String tag) {
        this.tag = tag;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        log.info("tag: {}", tag);
    }

}
