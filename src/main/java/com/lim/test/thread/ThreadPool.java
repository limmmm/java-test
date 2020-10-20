package com.lim.test.thread;

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
     * 周期线程池
     */
    public static void scheduledExecutor() throws InterruptedException {
        ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(1,
                r -> new Thread(r, "schedule"));
        scheduledExecutor.scheduleWithFixedDelay(() -> log.info("ScheduledThreadPool"), 2, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);

        scheduledExecutor.shutdown();
    }

}
