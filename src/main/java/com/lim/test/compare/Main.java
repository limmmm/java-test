package com.lim.test.compare;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 比较功能测试
 * @author lim
 * @since 2021-01-08
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
//        defaultSort();

//        implementsComparable();

//        implementsComparator();

        lambda();
    }

    /**
     * 默认排序，按字典序排列
     * 对象未实现comparable会报错
     */
    public static void defaultSort() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        String s4 = "aa";
        String s5 = "bb";
        List<String> list = Arrays.asList(s1, s2, s3, s4, s5);
        List<String> list2 = list.stream().sorted().collect(Collectors.toList());
        log.info("list: {}", list);
        log.info("list2: {}", list2);
    }

    /**
     * 继承Comparable，重写compareTo实现
     */
    private static void implementsComparable() {
        User2 u1 = new User2(1, 10);
        User2 u2 = new User2(1, 9);
        User2 u3 = new User2(2, 8);
        User2 u4 = new User2(2, 7);
        List<User2> list = Arrays.asList(u1, u2, u3, u4);
        List<User2> list2 = list.stream().sorted().collect(Collectors.toList());
        log.info("list: {}", list);
        log.info("list2: {}", list2);
    }

    /**
     * 继承Comparator，重写compare实现
     * 比较时需新建比较器Comparator
     */
    private static void implementsComparator() {
        User3 u1 = new User3(1, 10);
        User3 u2 = new User3(1, 9);
        User3 u3 = new User3(2, 8);
        User3 u4 = new User3(2, 7);
        List<User3> list = Arrays.asList(u1, u2, u3, u4);
        List<User3> list2 = list.stream().sorted(new User3()).collect(Collectors.toList());
        log.info("list: {}", list);
        log.info("list2: {}", list2);
    }

    /**
     * lambda
     * 比较时需新建比较器Comparator
     */
    private static void lambda() {
        User u1 = new User(1, 10);
        User u2 = new User(1, 9);
        User u3 = new User(2, 8);
        User u4 = new User(2, 7);
        List<User> list = Arrays.asList(u1, u2, u3, u4);

        // 使用lambda构建Comparator
        List<User> list2 = list.stream().sorted((a, b) -> {
            if (a.getId().equals(b.getId())) {
                return a.getAge().compareTo(b.getAge());
            }
            return a.getId().compareTo(b.getId());
        }).collect(Collectors.toList());

        // 新建比较器
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                if (a.getId().equals(b.getId())) {
                    return a.getAge().compareTo(b.getAge());
                }
                return a.getId().compareTo(b.getId());
            }
        };
        List<User> list3 = list.stream().sorted(comparator).collect(Collectors.toList());

        // 使用lambda新建比较器
        Comparator<User> comparator2 = (a, b) -> {
            if (a.getId().equals(b.getId())) {
                return a.getAge().compareTo(b.getAge());
            }
            return a.getId().compareTo(b.getId());
        };
        List<User> list4 = list.stream().sorted(comparator).collect(Collectors.toList());

        // 倒序
        List<User> list5 = list.stream().sorted(comparator.reversed()).collect(Collectors.toList());

        // 比较单属性
        List<User> list6 = list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());

        log.info("list: {}", list);
        log.info("list2: {}", list2);
        log.info("list3: {}", list3);
        log.info("list4: {}", list4);
        log.info("list5: {}", list5);
        log.info("list6: {}", list6);
    }


}
