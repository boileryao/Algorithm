package tree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by boileryao on 2018/3/19.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class BinaryTreeOperations {
    /**
     * invert a tree, which means for every node, swap their left and right child
     * Swap and Recurse can swap their orders, cause every node inverted then this tree inverted
     */
    public static <T> void invertTree(TreeNode<T> root) {
        if (root == null || /* is leaf: */ root.left == null && root.right == null) {
            return;
        }

        // swap
        TreeNode<T> tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // deep dark fantasy
        invertTree(root.left);
        invertTree(root.right);

    }

    /**
     * mid ordered walk through, a kind of `deep first search`
     */
    private static <T> void midOrderIterate(TreeNode<T> root) {
        if (root == null) return;
        midOrderIterate(root.left);
        System.out.print(root.value);
        midOrderIterate(root.right);
    }

    public static <T> String wideFirstIterate(TreeNode<T> root) {
        StringBuilder iterateBuilder = new StringBuilder();
        Queue<TreeNode<T>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> cur = queue.remove();
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            iterateBuilder.append(cur.value);
        }
        return iterateBuilder.toString();
    }


    /**
     * flatten a tree to linked format, on right branch
     */
    public static void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left != null) {
            TreeNode mostRightInLeftBranch = root.left;
            while (mostRightInLeftBranch.right != null) mostRightInLeftBranch = mostRightInLeftBranch.right;
            TreeNode right = root.right;
            root.right = root.left;
            mostRightInLeftBranch.right = right;
            root.left = null;
        }
    }

}