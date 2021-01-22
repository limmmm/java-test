package com.lim.test.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

/**
 * WARN: @Test会在主线程执行完成后关闭所有线程，导致子线程中断，需添加延迟以确保子线程执行完成
 * @author lim
 * @since 2021/1/22
 */
class CreateThreadTest {

    @Test
    void createThreadByExtend() throws InterruptedException {
        CreateThread.createThreadByExtend();
        Thread.sleep(2000);
    }

    @Test
    void createThreadByImpl() throws InterruptedException {
        CreateThread.createThreadByImpl();
        Thread.sleep(2000);
    }

    @Test
    void createByLambda() throws InterruptedException {
        CreateThread.createByLambda();
        Thread.sleep(2000);
    }

    @Test
    void createByInnerClassThread() throws InterruptedException {
        CreateThread.createByInnerClassThread();
        Thread.sleep(2000);
    }

    @Test
    void createByInnerClassRunnable() throws InterruptedException {
        CreateThread.createByInnerClassRunnable();
        Thread.sleep(2000);
    }

    @Test
    void createByImplCallable() throws ExecutionException, InterruptedException {
        // 拿到返回值后主线程才结束
        CreateThread.createByImplCallable();
    }

    @Test
    void createByExcutor() throws InterruptedException {
        CreateThread.createByExcutor();
        Thread.sleep(2000);
    }

}
