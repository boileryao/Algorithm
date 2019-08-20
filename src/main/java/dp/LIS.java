package dp;

/**
 * Created by boileryao on 2018/3/2.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class LIS {
    public static void main(String[] args) {
        lis(new float[]{1, 2, 3, 2, 5, 4, 5});  // 5
        lis(new float[]{89, 256, 78, 1, 46, 78, 8});  // 3
        lis(new float[]{6, 4, 8, 2, 17});  // 3
    }

    public static void lis(float[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && f[j] > f[i] - 1)
                    f[i] = f[j] + 1;
            }
        }
        System.out.println(f[n - 1]);
    }
}
