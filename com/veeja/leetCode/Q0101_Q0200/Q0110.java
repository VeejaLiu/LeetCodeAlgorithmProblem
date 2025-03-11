package com.veeja.leetCode.Q0101_Q0200;

import com.veeja.leetCode.util.TreeNode;
import org.junit.Test;

/**
 * TODO to confirm
 *
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class Q0110 {
    @Test
    public void test() {
        // 输入：root = [3,9,20,null,null,15,7]
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        // 输出：true
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(isBalanced(root));
    }

    @Test
    public void test2() {
        // 输入：root = [1,2,2,3,3,null,null,4,4]
        //        1
        //       / \
        //      2   2
        //     / \
        //    3   3
        //   / \
        //  4   4
        // 输出：false
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(isBalanced(root));
    }

    @Test
    public void test3() {
        // 输入：root = []
        // 输出：true
        System.out.println(isBalanced(null));
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


    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        while (root != null) {
            if (root.left == null && root.right == null) {
                return true;
            }

            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            if (Math.abs(leftMaxDepth - rightMaxDepth) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }
}
