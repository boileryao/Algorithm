package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by boileryao on 2019/12/23.
 * Licensed under WTFPL©2019.
 */
public class MajorityElement {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     */
    @LeetCode(id = 169, problemName = "majority-element", level = LeetCode.Level.EASY)
    public int majorityElement(int[] nums) {
        int majority = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                majority = num;
                cnt++;
                continue;
            }
            if (num == majority) cnt++;
            else cnt--;
        }

        return majority;
    }

    /**
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * <p>
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * <p>
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: [3]
     * <p>
     * 示例 2:
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element-ii
     */
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
