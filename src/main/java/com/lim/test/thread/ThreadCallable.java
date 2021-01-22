package com.lim.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author lim
 * @since 2021/1/22
 */
@Slf4j
public class ThreadCallable implements Callable<String> {

    private final String tag;

    public ThreadCallable(String tag) {
        this.tag = tag;
    }

    @Override
    public String call() throws Exception {
        log.info("tag: {}", tag);
        Thread.sleep(1000);
        return new StringBuffer(tag).reverse().toString();
    }
}
