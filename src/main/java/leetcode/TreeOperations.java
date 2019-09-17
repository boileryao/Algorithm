package leetcode;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/29/2019.
 * Licensed under WTFPL©2019.
 */
@SuppressWarnings("unused")
public class TreeOperations {
    @LeetCode(id = 94, problemName = "binary-tree-inorder-traversal", level = MEDIUM)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midOrderIterate(result, root);
        return result;
    }

    private void midOrderIterate(List<Integer> result, TreeNode root) {
        if (root == null) return;
        midOrderIterate(result, root.left);
        result.add(root.val);
        midOrderIterate(result, root.right);
    }
}
