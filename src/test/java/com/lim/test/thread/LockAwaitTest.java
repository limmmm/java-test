package com.lim.test.thread;

import org.junit.jupiter.api.Test;

/**
 * @author lim

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