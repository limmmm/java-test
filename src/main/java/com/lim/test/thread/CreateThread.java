package com.lim.test.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 创建线程操作测试
 *
 * @author lim
 * @date 2020/4/4
 */
@Slf4j
public class CreateThread {

    /** 通过继承Thread来创建线程 */
    public static void createThreadByExtend() {
        ThreadExtend thread = new ThreadExtend("thread A");
        thread.start();
        log.info("createThreadByExtend finished");
    }

    /** 通过实现Runnable来创建线程 */
    public static void createThreadByImpl() {
        ThreadImpl runnable = new ThreadImpl("thread B");
        Thread thread = new Thread(runnable);
        thread.start();
        log.info("createThreadByImpl finished");
    }

    /** 通过Lambda来创建线程 */
    public static void createByLambda() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("thread C");
        });
        thread.start();
        log.info("createByLambda finished");
    }

    /**
     * 使用匿名内部类方式创建，继承Thread
     * 作用与{@link #createByLambda()}相同
     */
    public static void createByInnerClassThread() {
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);
                log.info("Thread D");
            }
        };
        thread.start();
        log.info("createByInnerClass finished");
    }

    /**
     * 使用匿名内部类方式创建，实现Runnable
     * 作用与{@link #createByLambda()}相同
     */
    public static void createByInnerClassRunnable() {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);
                log.info("Thread E");
            }
        });
        thread.start();
        log.info("createByInnerClass finished");
    }

    /**
     * 使用实现Callable创建线程，具有返回结果
     */
    public static void createByImplCallable() throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable = new ThreadCallable("Thread F");
        FutureTask<String> task = new FutureTask<>(threadCallable);
        Thread thread = new Thread(task);
        thread.start();
        log.info("createByInnerClass finished");
        String result = task.get();
        log.info("result: {}", result);
    }

    /**
     * 使用线程池来创建线程
     */
    public static void createByExcutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Thread G");
        });
        log.info("createByExcutor finished");
    }

}
