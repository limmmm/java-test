package com.lim.test.thread;

import org.junit.jupiter.api.Test;

/**
 * @author Li Ming
 * @mail liming@tp-link.com.cn
 * @since 2021/3/11
 */
class LockAwaitTest {

    @Test
    void await() {
        LockAwait.await();
    }

    @Test
    void treadAwait() {
        LockAwait.treadAwait();
    }
}