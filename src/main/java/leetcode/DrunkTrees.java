package leetcode;

import model.TreeNode;

/**
 * Created by boileryao on 2020/3/28.
 * Licensed under WTFPL©2020.
 */
public class DrunkTrees {
    @LeetCode(id = 112, problemName = "path-sum", tag = "[BackTracking]", level = LeetCode.Level.EASY)
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int sumRemaining = sum - root.val;
        return sumRemaining == 0 || hasPathSum(root.left, sumRemaining) || hasPathSum(root.right, sumRemaining);
    }
}
