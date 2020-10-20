package com.lim.test.thread;

import org.junit.jupiter.api.Test;

/**
 * {@link ThreadPool} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
class ThreadPoolTest {

    @Test
    void fixedThreadPool() {
        ThreadPool.fixedThreadPool();
    }

    @Test
    void singleThreadExecutor() {
        ThreadPool.singleThreadExecutor();
    }

    @Test
    void scheduledExecutor() throws InterruptedException {
        ThreadPool.scheduledExecutor();
    }

}
