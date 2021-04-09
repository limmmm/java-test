package com.lim.test.thread.excutor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池创建
 *
 * @author lim
 * @date 2020/8/13
 */
@Slf4j
public class ThreadPool {

    /**
     * 定长线程池
     */
    public static void fixedThreadPool() {
        // 使用Executors创建，默认的拒绝策略AbortPolicy()
        ExecutorService executorService = Executors.newFixedThreadPool(5, Executors.defaultThreadFactory());

        // 手动创建线程池, 使用指定的拒绝策略ThreadPoolExecutor.DiscardOldestPolicy()
/*        ExecutorService executorService = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadPoolExecutor.DiscardPolicy());*/

        for (int i = 0; i < 10; i++) {
            final Integer ordinary = i;
            executorService.execute(() -> {
                log.info("tid: {}, ordinary: {}", Thread.currentThread().getId(), ordinary);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 单核线程池
     */
    public static void singleThreadExecutor() {
        // 使用Executors创建，默认的拒绝策略AbortPolicy()
//        ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());

        // 手动创建
        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; i++) {
            final Integer ordinary = i;
            executorService.execute(() -> {
                log.info("tid: {}, ordinary: {}", Thread.currentThread().getId(), ordinary);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 每次执行一个任务
     */
    public static void singleThreadExecutor2() {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                log.info("{}, {}", finalI, finalI == 5);
                if (finalI == 5) {
                    log.info("i1, {}", 111111);
                    int i1 = Integer.parseInt("aaaaa");
                    log.info("i1, {}", i1);
                }
                log.info("{}", Thread.currentThread().getName());
            });
/*            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void main(String[] args) {
        singleThreadExecutor2();
    }
}
