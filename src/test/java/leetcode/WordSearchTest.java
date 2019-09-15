package leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 9/14/2019.
 * Licensed under WTFPL©2019.
 */
public class WordSearchTest {
    WordSearch wordSearch = new WordSearch();
    char[][] board;

    @BeforeClass
    public void setup() {
        board = new char[][]{
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray(),
        };
    }

    @Test
    public void testExist_Case1() {
        Assert.assertTrue(wordSearch.exist(board, "ABCCED"));
        Assert.assertTrue(wordSearch._exist(board, "ABCCED"));
    }

    @Test
    public void testExist_Case2() {
        Assert.assertTrue(wordSearch.exist(board, "SEE"));
        Assert.assertTrue(wordSearch._exist(board, "SEE"));
    }

    @Test
    public void testExist_Case3() {
        Assert.assertFalse(wordSearch.exist(board, "ABCB"));
        Assert.assertFalse(wordSearch._exist(board, "ABCB"));
    }

    @Test
    public void testExist_Fail1() {
        Assert.assertTrue(wordSearch.exist(new char[][]{
                new char[]{'C', 'A', 'A'}, new char[]{'A', 'A', 'A'}, new char[]{'B', 'C', 'D'}
        }, "AAB"));
        Assert.assertTrue(wordSearch._exist(new char[][]{
                new char[]{'C', 'A', 'A'}, new char[]{'A', 'A', 'A'}, new char[]{'B', 'C', 'D'}
        }, "AAB"));
    }

    @Test
    public void testExist_Fail2() {
        Assert.assertFalse(wordSearch.exist(new char[][]{new char[]{'A', 'A'}}, "AAA"));
        Assert.assertFalse(wordSearch._exist(new char[][]{new char[]{'A', 'A'}}, "AAA"));
    }
}
