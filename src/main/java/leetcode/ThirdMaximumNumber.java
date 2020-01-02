package leetcode;

import java.util.TreeSet;

/**
 * Created by boileryao on 2020/1/2.
 * Licensed under WTFPL©2020.
 */
public class ThirdMaximumNumber {
    @LeetCode(id = 414, problemName = "third-maximum-number", level = LeetCode.Level.EASY)
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) treeSet.remove(treeSet.first());
        }
        return treeSet.size() >= 3 ? treeSet.first() : treeSet.last();
    }
}
