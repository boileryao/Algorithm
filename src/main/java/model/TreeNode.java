package model;

import leetcode.TreeOperations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    /**
     * @param values, negative value means null
     */
    public static TreeNode constructCompleteBinaryTree(int... values) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        TreeNode root = new TreeNode(values[0]);
        queue.add(root);

        boolean leftChild = true;
        for (int i = 1; i < values.length; i++) {
            int value = values[i];
            TreeNode treeNode = value >= 0 ? new TreeNode(value) : null;
            TreeNode head = queue.element();
            if (leftChild) {
                head.left = treeNode;
            } else {
                head.right = treeNode;
                queue.remove();
            }
            if (treeNode != null) queue.add(treeNode);
            leftChild = !leftChild;
        }

        return root;
    }

    /**
     * @return wide first traversal of this tree
     */
    @Override
    public String toString() {
        return Arrays.toString(new TreeOperations().wfsTraversal(this).toArray());
    }
}
