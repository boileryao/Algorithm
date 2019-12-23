package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by boileryao on 2019/12/23.
 * Licensed under WTFPL©2019.
 */
public class MajorityElement {
    @LeetCode(id = 229, problemName = "majority-element-ii", level = LeetCode.Level.MEDIUM)
    public List<Integer> majorityElementII(int[] nums) {
        if (nums == null || nums.length <= 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>(2);
        int m1 = nums[0], m2 = nums[0];
        int c1 = 0, c2 = 0;

        for (int num : nums) {
            if (c1 == 0 && num != m2) {
                m1 = num;
                ++c1;
                continue;
            }

            if (c2 == 0 && num != m1) {
                m2 = num;
                ++c2;
                continue;
            }

            if (m1 == num) {
                ++c1;
                continue;
            }
            if (m2 == num) {
                ++c2;
                continue;
            }
            --c1;
            --c2;
        }

        int oneThird = nums.length / 3;
        if (c1 != 0 && count(nums, m1) > oneThird) result.add(m1);
        if (c2 != 0 && count(nums, m2) > oneThird) result.add(m2);

        return result;
    }

    private int count(int[] nums, int tgt) {
        int cnt = 0;
        for (int num : nums) if (num == tgt) cnt++;
        return cnt;
    }
}
