package interview;

import java.util.Scanner;

/**
 * Created by boileryao on 2018/8/29.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 *
 * <h1>2019秋招#03</h1>
 */
public class MonsterCow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            int base = scanner.nextInt();
            int months = scanner.nextInt();
            System.out.println(base * makeLoveAndBreed(months));
        }
    }

    private static long makeLoveAndBreed_Naive(int month) {
        if (month <= 3) return month + 1;

        int bigBangMonth = month - 3;
        return 4 + (bigBangMonth * (bigBangMonth + 1)) / 2;
    }

    private static long makeLoveAndBreed(int month) {
        long amount = 1;
        long ableBreedCount = 1;
        long[] cowsAfterBorn = new long[3];  // count of cows afterBreed i days
        for (int i = 0; i < month; i++) {
            long newBorn = ableBreedCount;
            long newAbleToBreed = grownOneMonth(cowsAfterBorn);

            ableBreedCount += newAbleToBreed;
            cowsAfterBorn[0] = newBorn;
            amount += newBorn;
        }
        return amount;
    }

    private static long grownOneMonth(long[] cowsAfterBorn) {
        long newAbleToBreed = cowsAfterBorn[cowsAfterBorn.length - 1];

        if (cowsAfterBorn.length >= 1) {
            System.arraycopy(cowsAfterBorn, 0, cowsAfterBorn, 1, cowsAfterBorn.length - 1);
        }
        cowsAfterBorn[0] = 0;

        return newAbleToBreed;
    }
}