package com.lim.test.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lim
 * @since 2020-11-24
 */
@Slf4j
public class TestList {

    public static void list2Map() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "a"));
        list.add(new User(1L, "b"));
        list.add(new User(2L, "a"));

        // key冲突时不覆盖，使用已有值
        Map<Long, User> userMap1 = list.stream().collect(Collectors.toMap(User::getId, e -> e, (k1, k2) -> k1));
        // key冲突时覆盖，使用新值
        Map<Long, User> userMap2 = list.stream().collect(Collectors.toMap(User::getId, e -> e, (k1, k2) -> k2));
        log.info("userMap1: {}", userMap1);
        log.info("userMap2: {}", userMap2);
    }

    /**
     * 删除匹配的元素，注意remove只会删除一个匹配的元素
     */
    public static void removeEntry() {
        List<Long> ids = new ArrayList<>();

        ids.add(1L);
        ids.add(1L);
        ids.add(1L);
        ids.add(2L);
        ids.add(2L);
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        log.info("before: {}", ids);

        ids.remove(1L);
        log.info("remove 1: {}", ids);

        ids.remove(3L);
        log.info("remove 3: {}", ids);
    }
}
