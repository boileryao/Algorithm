package tree;


import com.sun.istack.internal.Nullable;

/**
 * Created by boileryao on 2018/3/19.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class TreeNode<T> {
    T value;
    @Nullable
    TreeNode<T> left;
    @Nullable
    TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
    }

    /**
     * A
     * /     \
     * B      C
     * / \   / \
     * D  E  F  G
     */
    public static TreeNode<Character> balancedTree() {
        TreeNode<Character> root = new TreeNode<>('A');
        root.left = new TreeNode<>('B');
        root.right = new TreeNode<>('C');
        root.left.left = new TreeNode<>('D');
        root.left.right = new TreeNode<>('E');
        root.right.left = new TreeNode<>('F');
        root.right.right = new TreeNode<>('G');
        return root;
    }

    public static TreeNode<Character> linearLeftTree(char... nodes) {
        TreeNode<Character> root = new TreeNode<>(nodes[0]);

        TreeNode<Character> current = root;
        for (int i = 1; i < nodes.length; i++) {
            current.left = new TreeNode<>(nodes[i]);
            current = current.left;
        }

        return root;
    }
}
