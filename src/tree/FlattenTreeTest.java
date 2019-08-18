package tree;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by boileryao on 2018/3/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class FlattenTreeTest {

    @Test
    public void testFlatten_BalancedTree() {
        TreeNode<Character> balancedTree = TreeNode.balancedTree();
        BinaryTreeOperations.flatten(balancedTree);
        StringBuilder result = new StringBuilder();
        preOrderIterate(balancedTree, result);
        String actual = result.toString();
        String expect = "ABDECFG";
        assertEquals(actual, expect);
    }

    @Test
    public void testFlatten_LinearTree() {
        TreeNode<Character> linearTree = TreeNode.linearLeftTree("ABCDEFG".toCharArray());
        BinaryTreeOperations.flatten(linearTree);

    }

    @Test
    public void testPreOrderIterate() {
        TreeNode<Character> linearTree = TreeNode.linearLeftTree("ABCDEFG".toCharArray());
        checkPreOrder(linearTree, "ABCDEFG");
    }

    private <T> void checkPreOrder(TreeNode<T> root, String expected) {
        StringBuilder result = new StringBuilder();
        preOrderIterate(root, result);
        String actual = result.toString();
        assertEquals(actual, expected);
    }

    private <T> void preOrderIterate(TreeNode<T> root, StringBuilder result) {
        if (root == null) return;
        result.append(root.value);
        preOrderIterate(root.left, result);
        preOrderIterate(root.right, result);
    }
}