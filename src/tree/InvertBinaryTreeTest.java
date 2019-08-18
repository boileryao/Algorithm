package tree;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by boileryao on 2018/3/19.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class InvertBinaryTreeTest {


    @Test
    public void testInvert_BalancedTree() {
        testInvert(TreeNode.balancedTree(), "GCFAEBD");
    }

    @Test
    public void testInvert_BalancedTree_DoubleInvert() {
        TreeNode<Character> tree = TreeNode.balancedTree();
        BinaryTreeOperations.invertTree(tree);

        testInvert(tree, "DBEAFCG");
    }

    @Test
    public void testInvert_LinearTree() {
        TreeNode<Character> leftLinearTree = TreeNode.linearLeftTree("ABCDEFG".toCharArray());
        testInvert(leftLinearTree, "ABCDEFG");
        assertNull(leftLinearTree.right.left);
    }

    @Test
    public void testInvert_LinearTree_DoubleInvert() {
        TreeNode<Character> leftLinearTree = TreeNode.linearLeftTree("ABCDEFG".toCharArray());
        BinaryTreeOperations.invertTree(leftLinearTree);

        testInvert(leftLinearTree, "GFEDCBA");
    }

    /**
     * @param tree tree to be inverted, of Characters
     * @param expect expected mid order walk through
     */
    private void testInvert(TreeNode<Character> tree, String expect) {
        StringBuilder actualBuilder = new StringBuilder();

        BinaryTreeOperations.invertTree(tree);
        midOrderIterate(tree, actualBuilder);
        String actual = actualBuilder.toString();

        assertEquals(actual, expect);
    }

    private <T> void midOrderIterate(TreeNode<T> root, StringBuilder result) {
        if (root == null) return;
        midOrderIterate(root.left, result);
        result.append(root.value);
        midOrderIterate(root.right, result);
    }

}