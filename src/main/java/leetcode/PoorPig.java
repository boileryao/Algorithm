package leetcode;

/**
 * Created by boileryao on 2017/2/22.
 */
public class PoorPig {
    public static void main(String[] args) {
        PoorPig poorPig = new PoorPig();
        System.out.println(poorPig.poorPigs(1, 1, 1));
        System.out.println(poorPig.poorPigs(1000, 15, 60));
    }

    @LeetCode(id = 458, problemName = "poor-pigs", level = LeetCode.Level.HARD)
    private int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 1;
        int base = minutesToTest / minutesToDie + 1;

        if (buckets == 1) {
            return 0;
        }

        buckets = buckets - 1;
        while ((buckets /= base) > 0) {
            pigs++;
        }

        return pigs;
    }
}
