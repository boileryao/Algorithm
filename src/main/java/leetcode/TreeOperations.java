package leetcode;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static leetcode.LeetCode.Level.EASY;
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

    @LeetCode(id = 226, problemName = "invert-binary-tree", level = EASY)
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> wfq = new ArrayDeque<>();
        if (root != null) wfq.add(root);

        while (wfq.size() > 0) {
            TreeNode current = wfq.remove();
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;
            if (current.left != null) wfq.add(current.left);
            if (current.right != null) wfq.add(current.right);
        }

        return root;
    }

    private void midOrderIterate(List<Integer> result, TreeNode root) {
        if (root == null) return;
        midOrderIterate(result, root.left);
        result.add(root.val);
        midOrderIterate(result, root.right);
    }
}
