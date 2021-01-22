package com.lim.test.thread.excutor;

import org.junit.jupiter.api.Test;

/**
 * @author lim
 * @since 2021/1/22
 */
class ScheduledExecutorPoolTest {

    @Test
    void createByExcutors() throws InterruptedException {
        ScheduledExecutorPool.createByExcutors();
    }

    @Test
    void createByScheduledThreadPoolExecutor() throws InterruptedException {
        ScheduledExecutorPool.createByScheduledThreadPoolExecutor();
    }
}