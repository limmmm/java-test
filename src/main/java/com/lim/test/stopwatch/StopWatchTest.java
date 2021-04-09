package com.lim.test.stopwatch;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;

/**
 * StopWatch 基础使用
 *
 * @author lim
 * @date 2020/10/15
 */
@Slf4j
public class StopWatchTest {

    public static void main(String[] args) throws InterruptedException {
        runStopWatch();
    }

    /**
     * StopWatch 使用
     * @throws InterruptedException InterruptedException
     */
    public static void runStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("a");
        Thread.sleep(100);
        stopWatch.stop();
        log.info("task：{}, 运行时间：{}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        stopWatch.start("b");
        Thread.sleep(200);
        stopWatch.stop();
        log.info("task：{}, 运行时间：{}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        stopWatch.start("c");
        Thread.sleep(200);
        stopWatch.stop();
        log.info("task：{}, 运行时间：{}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        //WARN: 不在task监听范围内，不纳入总时长统计
        Thread.sleep(1000);

        stopWatch.start("d");
        Thread.sleep(300);
        stopWatch.stop();
        log.info("task：{}, 运行时间：{}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        log.info("总任务数 {}, 任务总时长：{}", stopWatch.getTaskInfo().length, stopWatch.getTotalTimeMillis());
    }

}
