package tree;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by boileryao on 2018/3/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class WideFirstIterateTest {

    @Test
    public void testWideFirstIterate_BalancedTree() {
        TreeNode<Character> balancedTree = TreeNode.balancedTree();
        assertEquals(BinaryTreeOperations.wideFirstIterate(balancedTree), "ABCDEFG");
    }

    @Test
    public void testWideFirstIterate_LinkedTree() {
        TreeNode<Character> linearLeftTree = TreeNode.linearLeftTree("ABCDEFG".toCharArray());
        assertEquals(BinaryTreeOperations.wideFirstIterate(linearLeftTree), "ABCDEFG");
    }
}