package com.ti.huawei.od.Algorithm;

import java.util.LinkedList;
import java.util.Queue;
public class erchadepth {
    /**
     * 递归
     *
     * @param root
     * [@return](/profile/547241) */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
    /**
     * 非递归，层次遍历
     *
     * @param root
     * [@return](/profile/547241) */
    public int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        int start = 0;
        int end = 1;
        Queue queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = (TreeNode) queue.poll();
            start++;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                depth++;
            }
        }
        return depth;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
