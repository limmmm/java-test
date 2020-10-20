package com.lim.test.hashtest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link HashUser} 测试
 *
 * @author lim
 * @date 2020/10/20
 */
class HashUserTest {

    @Test
    void testHashCode() {
        HashUser user1 = new HashUser("1", "name", 10);
        HashUser user2 = new HashUser("1", "name", 10);

        Assert.assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

}