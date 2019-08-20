package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by boileryao on 2018/4/5.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class CowSheep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int[] cards = new int[amount];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = scanner.nextInt();
        }
        Arrays.sort(cards);

        int gradesDiff = 0;
        for (int i = cards.length - 1; i > 0; i -= 2) {
            gradesDiff += cards[i] - cards[i - 1];
        }

        if (cards.length % 2 != 0) gradesDiff += cards[0];

        System.out.println(gradesDiff);
    }
}
