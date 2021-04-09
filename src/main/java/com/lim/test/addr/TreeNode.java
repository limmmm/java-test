package com.lim.test.addr;

import lombok.Data;

/**
 * @author lim
 * @mail liming@tp-link.com.cn
 * @since 2020-12-14
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
