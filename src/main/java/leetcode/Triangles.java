package leetcode;

import java.util.List;

/**
 * Created by boileryao on 2020/2/9.
 * Licensed under WTFPL©2020.
 */
public class Triangles {
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     */
    @LeetCode(id = 120, problemName = "triangle", tag = "[DP]", level = LeetCode.Level.MEDIUM)
    public int minimumTotal(List<List<Integer>> triangle) {
        int lastRowSize = triangle.get(triangle.size() - 1).size();
        int[] arr = new int[lastRowSize];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // copy last row when beginning
                if (i == triangle.size() - 1) {
                    arr[j] = triangle.get(i).get(j);
                } else {
                    arr[j] = triangle.get(i).get(j) + Math.min(arr[j], arr[j + 1]);
                }
            }
        }

        return arr[0];
    }
}
