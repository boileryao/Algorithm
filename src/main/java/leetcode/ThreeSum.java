package leetcode;

import java.util.*;

/**
 * Created by boileryao on 2018/2/11.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
@SuppressWarnings("unused")
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[3000];
        for (int i = 0; i < 3000; i++) {
            nums[i] = i * (i - 20);
        }
        long beginTime = System.currentTimeMillis();
        for (List<Integer> integers : threeSum.threeSumBak(nums)) {
            System.out.println(new Triplets(integers.get(0), integers.get(1)));
        }
        System.out.format("%d ms used\n", System.currentTimeMillis() - beginTime);
    }

    @LeetCode(id = 15, problemName = "3sum", level = LeetCode.Level.MEDIUM)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        // improve: skip duplicates
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        lo++;
                    } else {
                        // improve: skip duplicates
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    @LeetCode(id = 16, problemName = "3sum-closest", level = LeetCode.Level.MEDIUM)
    public int threeSumClosest(int[] nums, final int target) {
        if (nums.length < 3) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int targetTwoSum = target - nums[i];
                int thisSum = nums[start] + nums[end] + nums[i];
                int thisSumDiff = thisSum - target;
                if (Math.abs(thisSumDiff) < Math.abs(closest - target)) {
                    closest = thisSum;
                    // target match
                    if (thisSum == target) {
                        return target;
                    }
                }

                // shrink
                if (nums[start] + nums[end] < targetTwoSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return closest;
    }

    // this function may work, and time complex is O(n*n*lgn), limitation is objects, exciting
    private List<List<Integer>> threeSumBak(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        int mid = 0;  // first occurrence of non negative num
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                mid = i;
                break;
            }
        }

        if (mid == 0 && nums[nums.length - 1] != 0) {
            return Collections.emptyList();
        }

        int[] negatives = Arrays.copyOfRange(nums, 0, mid);
        int[] nonNegatives = Arrays.copyOfRange(nums, mid, nums.length);

        List<Triplets> triplets = new LinkedList<>();
        List<Integer[]> integerPairList = everyTwoSums(negatives);
        for (Integer[] ab : integerPairList) {
            int sum = ab[0] + ab[1];
            int idx = Arrays.binarySearch(nonNegatives, -sum);
            if (idx >= 0) {
                triplets.add(new Triplets(ab[0], ab[1]));
            }
        }

        integerPairList = everyTwoSums(nonNegatives);
        for (Integer[] ab : integerPairList) {
            int sum = ab[0] + ab[1];
            int idx = Arrays.binarySearch(negatives, -sum);
            if (idx >= 0) {
                triplets.add(new Triplets(ab[0], ab[1]));
            }
        }

        if (nums[mid] == 0 && mid + 2 < nums.length) {
            if (nums[mid + 1] == 0 && nums[mid + 2] == 0) {
                triplets.add(new Triplets(0, 0));
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        for (Triplets tri : triplets) {
            result.add(tri.toList());
        }

        return result;
    }

    private List<Integer[]> everyTwoSums(int[] nums) {
        List<Integer[]> result = new ArrayList<>((nums.length * (nums.length - 1) / 2));
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result.add(new Integer[]{nums[i], nums[j]});
            }
        }
        return result;
    }

    static class Triplets {
        int a;
        int b;

        Triplets(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return a + b;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Triplets)) return false;
            return a == ((Triplets) obj).a && b == ((Triplets) obj).b;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d, %d]", a, b, -a - b);
        }

        public List<Integer> toList() {
            return Arrays.asList(a, b, -a - b);
        }
    }
}
