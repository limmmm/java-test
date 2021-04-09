package com.lim.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lim

 * @since 2021/3/11
 */
@Slf4j
public class LockAwait {

    public static void main(String[] args) {
        await();
    }

    public static void await() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        int n = 3;
        log.info("start");
        while (n-- > 0) {
            lock.lock();
            try {
                condition.await(1000L, TimeUnit.MILLISECONDS);
                log.info("n: {}", n);
//                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void treadAwait() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                log.info("threadA. before wait");
//                lock.wait(1000L);

                condition.await(1000L, TimeUnit.MILLISECONDS);
                log.info("threadA. after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            log.info("threadA finish");
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                log.info("threadB. before wait");
                condition.await(1000L, TimeUnit.MILLISECONDS);
                log.info("threadB. after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            log.info("threadB finish");
        });

        threadA.start();
        threadB.start();
    }

}
