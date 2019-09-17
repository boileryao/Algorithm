package leetcode;

/**
 * Created by boiler-yao on 2017/1/23.
 * A function like Integer.bitCount()
 */
@SuppressWarnings("unused")
public class BitCounter {
    private int count(int num) {
        int count = num;
        int a = 0x55555555; //010101010101010101010101010101 //用于相邻的两位相加
        int b = 0x33333333; //用于相邻的四位相加
        int c = 0x0f0f0f0f;
        int d = 0x00ff00ff;
        int e = 0x0000ffff;

        count = (count & a) + ((count >> 1) & a);
        count = (count & b) + ((count >> 2) & b);
        count = (count & c) + ((count >> 4) & c);
        count = (count & d) + ((count >> 8) & d);
        count = (count & e) + ((count >> 16) & e);

        return count;
    }

    int hammingDistance(int a, int b) {
        return count(a ^ b);
    }
}
