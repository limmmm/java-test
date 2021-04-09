package com.lim.test.addr;

import lombok.extern.slf4j.Slf4j;

/**
 * 父类/子类地址转化测试
 *
 * @author lim
 * @since 2020-12-03
 */
@Slf4j
public class Test2 {

    public static void main(String[] args) {

        Test2 t = new Test2();
//        System.out.println(t.removeDuplicates(new int[]{1, 3, 3, 3}));
//        System.out.println(t.removeElement(new int[]{3, 2, 2, 3}, 3));
//        System.out.println(t.strStr2("hello", "ll"));
//        System.out.println(t.searchInsert(new int[]{1,3,4,5}, 0));

//        System.out.println(t.countAndSay(1));
//        System.out.println(t.countAndSay(2));
//        System.out.println(t.countAndSay(3));
//        System.out.println(t.countAndSay(4));

//        System.out.println(t.lengthOfLastWord("a    "));
//        System.out.println(t.climbStairs(3));
//        System.out.println(t.climbStairs(4));
//        System.out.println(t.climbStairs(5));

        int[] a = new int[] {2, 0};
        int[] b = new int[] {1};
        t.merge(a, 1, b, 1);
        log.info("{}", a);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;
        while (n > 0) {
            if (m == 0 || nums2[n-1] > nums1[m-1]) {
                // nums1全部都移到队尾或nums2的最后一个元素比nums1大,使用nums2填充nums1尾部
                nums1[last] = nums2[n-1];
                n--;
            } else {
                // nums1的最后一个元素大于等于nums2,使用nums1填充nums1尾部
                nums1[last] = nums1[m-1];
                m--;
            }
            last--;
        }
    }


    public int climbStairs(int n) {
        // 一级
        int a = 1;
        if (n == 1) {
            return a;
        }

        // 二级
        int b = 2;
        if (n == 2) {
            return b;
        }

        // 三级以上, 爬到n级有两种方式：从n-1级爬一级或者从n-2级爬两级
        // f(n) = f(n - 1) + f(n - 2)
        // 使用滚动数组代替递归
        int rs = 0;
        while (n-- > 2) {
            rs = a + b;
            a = b;
            b = rs;
        }
        return rs;
    }

    public int mySqrt(int x) {
        int rs = 1;
        while (rs < x / rs) {
            rs++;
        }
        return rs == x / rs ? rs : rs -1;
    }


    public int lengthOfLastWord(String s) {

        // 找出最后一个不为空格的下标
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        if (end < 0) {
            return 0;
        }

        // 找出单词开始前一个空格的下标，不存在为-1
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }

}
