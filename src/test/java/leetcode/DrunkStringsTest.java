package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by boileryao on 2020/3/13.
 * Licensed under WTFPL©2020.
 */
public class DrunkStringsTest {
    private DrunkStrings drunkStrings = new DrunkStrings();

    @Test
    public void testGcdOfStrings_Case1() {
        assertEquals(drunkStrings.gcdOfStrings("ABABAB", "ABAB"), "AB");
    }

    @Test
    public void testGcdOfStrings_Case2() {
        assertEquals(drunkStrings.gcdOfStrings("ABCABC", "ABC"), "ABC");
    }

    @Test
    public void testGcdOfStrings_Case3() {
        assertEquals(drunkStrings.gcdOfStrings("LEET", "CODE"), "");
    }

    @Test
    public void testCountCharacters_1() {
        String[] dict = {"cat", "bt", "hat", "tree"};
        Assert.assertEquals(drunkStrings.countCharacters(dict, "atach"), 6);
    }

    @Test
    public void testCountCharacters_2() {
        String[] dict = {"hello", "world", "leetcode"};
        Assert.assertEquals(drunkStrings.countCharacters(dict, "welldonehoneyr"), 10);
    }

    @Test
    public void testCountCharacters_Fail1() {
        String[] dict = {
                "pxlqovnbsgvqjzpfeidchzrodnbqfrccfydzjptukscjuatlsrcurepllxzyghhdepitqptlmfkhzxjgswaulxkfydhkilg",
                "os", "pozekufhlooosxpcggbi", "xzaoxzllcixfqbupqozmzrnugj", "j", "tgslwp",
                "ntrdkixexajlpjgmcbrqimwtqnzfrqjszeiuvrgzclerzmsnagzaxbredvlrmipzflrzusclckmxphc",
                "aymovnuhptozhkiyowbeguzlkmrwjnujgjbdne", "abc", "vxoigovwmqizmkwbkktqk",
                "qgndjgvzcyajhgmrrnhdywwdbmkhtthwcfiueuxfldanyrmccwcy"};
        Assert.assertEquals(drunkStrings.countCharacters(dict, "figspbov"), 2);
    }

    @Test
    public void testLongestPalindrome() {
        Assert.assertEquals(drunkStrings.longestPalindrome("abAAAAdd"), 7);
    }

    @Test
    public void testLongestPalindrome_Fail1() {
        Assert.assertEquals(drunkStrings.longestPalindrome("aacccbbb"), 7);
    }
}
