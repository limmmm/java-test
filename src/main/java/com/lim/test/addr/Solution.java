package com.lim.test.addr;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lim

 * @since 2020-12-04
 */
@Slf4j
class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(5);
        node2.next.next.next = new ListNode(7);
        node2.next.next.next.next = new ListNode(7);

        Solution s = new Solution();
//        log.info("{}", s.mergeTwoLists(node, node2));
//        log.info("{}", s.deleteDuplicates(node));

        int[] a = new int[]{2, 7, 11, 15};
//        TreeNode rs = s.sortedArrayToBST(a);
//        log.info("{}", s.sortedArrayToBST(a));

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(3);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        log.info("{}", s.hasPathSum(root, 13));

//        log.info("{}", s.getRow(3));

        int b = 100;
        int c = 100;
//        log.info("{}", b ^ c);

//        log.info("{}", s.twoSum(a, 9));
//        log.info("{}", s.convertToTitle(28));
//        log.info("{}", s.hammingWeight(Integer.));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rs = 0;
        while (n > 0) {
            rs += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
        return rs;
    }


    public int trailingZeroes(int n) {
        // 5的倍数的个数 + 25的倍数的个数 + 125的倍数的个数
        // n/5 + n/25 + n/125 + ....
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;

        /*// 质因数中5的个数即为0的个数
        int rs = 0;

        for (int i = 5; i <= n; i = i + 5) {
            int t = 5;
            while (i % t == 0) {
                rs++;
                t *= 5;
            }
        }
        return rs;*/
    }

    public int titleToNumber(String s) {
        // 采用进制转化思想，对于26进制数abcd，对应的10进制为 (((a) * 26 + b) * 26 + c) * 26 + d
        int rs = 0;

        for (int i = 0; i < s.length(); i++) {
            rs = rs * 26 + (s.charAt(i) - 'A' + 1);
        }

        return rs;

//        // 系数
//        int ser = 1;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            rs += (s.charAt(i) - 'A' + 1) * ser;
//            ser *= 26;
//        }
//        return rs;
    }

    public int majorityElement(int[] nums) {
        // 随机选取一个数与一个不相等的数抵消，最后剩下的一定是众数

        // 选举的众数
        Integer rs = null;
        // 可抵消的次数
        int cnt = 0;

        for (int num : nums) {
            if (cnt == 0) {
                rs = num;
            }
            cnt += num == rs ? 1 : -1;
        }
        return rs;
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            // 从0开始
            n--;
            sb.append((char) ('A' + n % 26));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public int[] twoSum(int[] numbers, int target) {
        // 根据升序及一定有且只有一个解的特性，从两端向中间进行夹逼
        int l = 0;
        int r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) {
                // 大了将右指针左移一位
                r--;
            } else {
                // 小了将左指针右移一位
                l++;
            }
        }
        return new int[]{l+1, r+1};
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 若有相交，则 a + b、 b + c的长度相等且后半段端相同，
        // 即均步进n步后，a + b、b + c的指向相同元素
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }

        return a;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public int singleNumber(int[] nums) {
        // a^a = 0
        // 0^0 = 0
        // 0^a = a
        return Arrays.stream(nums).reduce((a, b) -> a^b).getAsInt();
    }

    public boolean isPalindrome(String s) {
        if (StringUtils.isBlank(s)) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }



    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        // 买入最小值
        int buy = Integer.MAX_VALUE;
        // 卖出利益最大值
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                // 购买
                buy = prices[i];
            } else if (i != prices.length - 1 && prices[i] > prices[i+1]) {
                // 卖-非最后一天到达顶点
                profit += prices[i] - buy;
                buy = Integer.MAX_VALUE;
            } else if (i == prices.length - 1 && prices[i] > buy) {
                // 卖-最后一天到达顶点
                profit += prices[i] - buy;
                buy = Integer.MAX_VALUE;
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        // 买入最小值
        int buy = prices[0];
        // 卖出利益最大值
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rs = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            // 每一行第一个元素为1
            row.add(1);

            if (i != 0) {
                // 非第一行

                // 上一行相邻两数之和
                for (int j = 0; j < rs.get(i - 1).size() - 1; j++) {
                    row.add(rs.get(i - 1).get(j) + rs.get(i - 1).get(j + 1));
                }

                // 最后一个数
                row.add(1);
            }

            rs.add(row);
        }
        return rs.get(rowIndex);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            // 叶子节点
            if (sum == 0) {
                return true;
            }
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> level = new LinkedList<>();

        level.add(root);

        int minDepth = 0;
        while (!level.isEmpty()) {
            List<TreeNode> newLevel = new LinkedList<>();
            for (TreeNode treeNode : level) {
                if (treeNode.left == null && treeNode.right == null) {
                    return minDepth + 1;
                } else {
                    if (treeNode.left != null) {
                        newLevel.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        newLevel.add(treeNode.right);
                    }
                }
            }
            minDepth++;
            level = newLevel;
        }
        return minDepth;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 根据中间元素生成平衡树，只有一个子节点时生成右支
     */
    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l <= r) {
            int center = l + (r - l) / 2;
            TreeNode treeNode = new TreeNode(nums[center]);
            treeNode.left = sortedArrayToBST(nums, l, center - 1);
            treeNode.right = sortedArrayToBST(nums, center + 1, r);
            return treeNode;
        }
        return null;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode rs = head;
        ListNode tmp = rs;
        while (head !=null && head.next != null) {
            head = head.next;
            if (tmp.val < head.val) {
                tmp.next = head;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return rs;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个虚拟节点
        ListNode node = new ListNode(-1);
        ListNode tmp = node;

        while (l1 != null && l2 != null) {
            // 拼接l1、l2中值更小的节点
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        // 当l1或l2拼接完成后，直接拼接另外一个链表剩余部分
        // 可能另外一个链表也为null
        tmp.next = l1 == null ? l2 : l1;
        return node.next;
    }

}