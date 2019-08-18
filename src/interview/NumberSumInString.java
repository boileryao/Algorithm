package interview;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by boileryao on 2018/8/29.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 *
 * <h1>2019秋招#01</h1>
 */
public class NumberSumInString {
    private static final Pattern numberPattern = Pattern.compile("-*\\d+");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mixedNumbersString = scanner.nextLine();
        System.out.println(sumIntegers(mixedNumbersString));
    }

    public static long sumIntegers(String str) {
        long sum = 0;
        Matcher matcher = numberPattern.matcher(str);
        while (matcher.find()) {
            int number = numberStringToInteger(matcher.group());
            sum += number;
        }
        return sum;
    }


    /* numStr: -*\\d+ */
    private static int numberStringToInteger(String numStr) {
        String normalizedNumberStr = numStr.replaceAll("--", "");
        return Integer.valueOf(normalizedNumberStr);
    }
}
