package com.lim.test.addr;

import lombok.Data;

/**
 * @author lim
 * @mail liming@tp-link.com.cn
 * @since 2020-12-07
 */
@Data
public class ListNode {
      int val;
      ListNode next;

      ListNode(int x) { val = x; }
}
