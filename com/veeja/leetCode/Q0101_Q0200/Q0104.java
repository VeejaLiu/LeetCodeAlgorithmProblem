package com.veeja.leetCode.Q0101_Q0200;

import com.veeja.leetCode.util.TreeNode;
import org.junit.Test;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 */

public class Q0104 {

    @Test
    public void test() {
        // 输入：root = [3,9,20,null,null,15,7]
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        // 输出：3
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(root));
    }

    @Test
    public void test2() {
        // 输入：root = [1,null,2]
        //        1
        //         \
        //          2
        // 输出：2
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
