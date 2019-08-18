package interview;

import java.util.Scanner;

/**
 * Created by boileryao on 2018/4/20.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class DigitsStatistics {
    public static void main(String[] args) {
        System.out.println(statistic(Integer.MAX_VALUE / 2));
        System.out.println(statistic(1_000_000_000));
        System.out.println(statistic(999_999_999));
        System.out.println(statistic(999_999));
        System.out.println(statistic(999));
        System.out.println(statistic(13));
        System.out.println(statistic(4));
        System.out.println(statistic(0));
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println(statistic(scanner.nextLong()));
        }
    }

    public static long statistic(long num) {
        System.out.println("statistic: " + num);
        if (num < 10) return num == 0 ? 1 : num;
        int digits = Long.toString(num).length();
        long len = 0;
        long tmp = 1;
        for (int i = 1; i < digits; i++) {
            len += i * 9 * tmp;
            tmp *= 10;
        }
        long extra = digits * (num - tmp + 1);
        System.out.println(len + ", " + extra);
        return len + extra;
    }
}
