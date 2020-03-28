package leetcode;

import model.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/3/28.
 * Licensed under WTFPL©2020.
 */
public class DrunkTreesTest {
    private DrunkTrees drunkTrees = new DrunkTrees();

    /**
     * <pre>
     *         5
     *        / \
     *       4   8
     *      /   / \
     *     11  13  4
     *    /  \      \
     *   7    2      1
     * </pre>
     */
    @Test
    public void testHasPathSum() {
        TreeNode root = TreeNode.constructCompleteBinaryTree(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, 1);
        Assert.assertTrue(drunkTrees.hasPathSum(root, 22));
    }
}
