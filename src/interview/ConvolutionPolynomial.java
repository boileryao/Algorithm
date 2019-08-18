package interview;

import java.util.Scanner;

/**
 * Created by boileryao on 2018/8/29.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 *
 * <h1>2019秋招#02</h1>
 * 最高阶为4的两个多项式, 系数为复数. 同一个系数先输入实部再输入虚部, 同一个多项式的系数一起输入, 且先输入的为高阶项. 即输入共 20 个数
 * 阶数分别为8..0, 即输出共18个数
 */
public class ConvolutionPolynomial {
    private static final int MAX_RANK = 4;

    public static void main(String[] args) {
        int[][] a = new int[MAX_RANK + 1][2];
        int[][] b = new int[MAX_RANK + 1][2];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = scanner.nextInt();
            }
        }

        int[][] convolutions = convolution(a, b);
        for (int i = convolutions.length - 1; i >= 0; i--) {
            System.out.println(convolutions[i][0]);
            System.out.println(convolutions[i][1]);
        }
    }

    private static int[][] convolution(int[][] a, int[][] b) {
        int[][] result = new int[(MAX_RANK * 2 + 1)][2];
        for (int rank1 = 0; rank1 <= MAX_RANK; rank1++) {
            for (int rank2 = 0; rank2 <= MAX_RANK; rank2++) {
                int convRank = 2 * MAX_RANK - rank1 - rank2;
                result[convRank][0]/*实部*/ += a[rank1][0] * b[rank2][0] - a[rank1][1] * b[rank2][1];
                result[convRank][1]/*虚部*/ += a[rank1][0] * b[rank2][1] + a[rank1][1] * b[rank2][0];
            }
        }
        return result;
    }

}
