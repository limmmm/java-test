package com.lim.test.addr;

import lombok.Data;

/**
 * @author lim

 * @since 2020-12-07
 */
@Data
public class ListNode {
      int val;
      ListNode next;

      ListNode(int x) { val = x; }
}
