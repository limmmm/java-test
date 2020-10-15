package stopwatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @author Li Ming
 * @date 2020/10/15
 */
@Slf4j
public class StopWatchTest {

    public static void main(String[] args) throws InterruptedException {
        runStopWatch();
    }

    /**
     * StopWatch 使用
     * @throws InterruptedException
     */
    private static void runStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("a");
        Thread.sleep(100);
        stopWatch.stop();
        log.info("{}, {}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        stopWatch.start("b");
        Thread.sleep(200);
        stopWatch.stop();
        log.info("{}, {}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        stopWatch.start("c");
        Thread.sleep(200);
        stopWatch.stop();
        log.info("{}, {}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        stopWatch.start("d");
        Thread.sleep(300);
        stopWatch.stop();
        log.info("{}, {}, {}", stopWatch.getLastTaskInfo(), stopWatch.getLastTaskName(),
                stopWatch.getLastTaskTimeMillis());

        log.info("{}, {}", stopWatch.getTaskInfo(), stopWatch.getTotalTimeMillis());
    }
}
