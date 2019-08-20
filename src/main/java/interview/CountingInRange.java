package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by boileryao on 2018/9/6.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 * <p>
 * 题目描述：
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * 1、r-l+1=k;
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 * 输出满足条件的区间个数。
 * <p>
 * 输入
 * 第一行三个整数n,k,t(1≤n,k,t≤105。
 * 第二行 n 个整数，a1 , a2 , ... an (1≤ai≤105)。
 * <p>
 * 输出
 * 输出一个数，问题的答案。
 * <p>
 * 样例输入
 * 5 3 2
 * 3 1 1 1 2
 * 样例输出
 * 3
 */
public class CountingInRange {
    // accepted
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Map<Integer, Integer> countBuffer = new HashMap<>(k);
        for (int i = 0; i < k; i++) {
            int newValue;
            if (countBuffer.containsKey(numbers[i])) {
                newValue = countBuffer.get(numbers[i]) + 1;
            } else {
                newValue = 1;
            }
            countBuffer.put(numbers[i], newValue);
        }

        int rangeCount = getMax(countBuffer) >= t ? 1 : 0;
        for (int rangeEnd = k; rangeEnd < numbers.length; rangeEnd++) {
            int oldRangeStart = rangeEnd - k;
            int oldRangeStartNumber = numbers[oldRangeStart];
            if (countBuffer.get(oldRangeStartNumber) == 1) {
                countBuffer.remove(oldRangeStartNumber);
            } else {
                countBuffer.put(oldRangeStartNumber, countBuffer.get(oldRangeStartNumber) - 1);
            }

            if (countBuffer.containsKey(numbers[rangeEnd])) {
                countBuffer.put(numbers[rangeEnd], countBuffer.get(numbers[rangeEnd]) + 1);
            } else {
                countBuffer.put(numbers[rangeEnd], 1);
            }

            rangeCount += getMax(countBuffer) >= t ? 1 : 0;
        }

        System.out.println(rangeCount);

    }

    // change stream() to foreach
    // from 82%(Time Limit Exceeded) to accepted
    private static int getMax(Map<Integer, Integer> countBuffer) {
        int max = Integer.MIN_VALUE;
        for (int count : countBuffer.values()) {
            if (count > max) max = count;
        }
        return max;
    }

}
