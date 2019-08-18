package leetcode;

/**
 * Created by boiler-yao on 2016/12/20.
 * Check if the given number is a power of ex2.
 */
public class PowerTwo {
    public static void main(String[] args) {
        PowerTwo powerTwo = new PowerTwo();
        powerTwo.run(2);
        powerTwo.run(24);
        powerTwo.run(128);
        powerTwo.run(1024);
    }

    private void run(int num) {
        System.out.println((num & (num - 1)) == 0);
    }
}
