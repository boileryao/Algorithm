package lcof;

/**
 * Created by boileryao on 2018/9/9.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 * <p>
 * Do `add` without build-in signs
 */
public class _65_FannyAdd {
    public static int add(int a, int b) {
        int tmpAnd = a & b;
        int tmpSum = a ^ b;

        while (tmpAnd != 0) {
            int oldTmpSum = tmpSum;
            tmpSum = tmpSum ^ (tmpAnd << 1);
            tmpAnd = oldTmpSum & (tmpAnd << 1);
        }
        System.out.println(Integer.toBinaryString(tmpAnd));
        System.out.println(Integer.toBinaryString(tmpSum));

        return tmpSum;
    }
}
