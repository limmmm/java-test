package com.lim.test.hashtest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Assertions.assertEquals(user1, user1);
        Assertions.assertEquals(user1.hashCode(), user2.hashCode());
    }

}