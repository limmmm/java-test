package com.lim.test.thread.excutor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 周期线程池
 * @author lim
 * @since 2021/1/22
 */
@Slf4j
public class ScheduledExecutorPool {

    /**
     * 使用Executors创建
     */
    public static void createByExcutors() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(getRunnable(), 0, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledExecutorService.shutdown();
    }

    /**
     * 使用Executors创建
     */
    public static void createByScheduledThreadPoolExecutor() throws InterruptedException {
//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                r -> new Thread(r, "schedule"));
//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, getThreadFactory());

        scheduledExecutorService.scheduleAtFixedRate(getRunnable(), 0, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledExecutorService.shutdown();
    }

    /**
     * 创建Runnable
     */
    private static Runnable getRunnable() {
        return () -> {log.info("schedule excute");};
    }

    private static ThreadFactory getThreadFactory() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "schedule");
            }
        };
    }

    private static ThreadFactory getThreadFactoryLambda() {
        return r -> new Thread(r, "schedule");
    }

}
