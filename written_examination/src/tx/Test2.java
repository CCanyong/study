package tx;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 26/04/2020 21:09
 * 2
 * 4
 * 0 0
 * 0 1
 * 1 0
 * 1 1
 * 2 2
 * 2 3
 * 3 2
 * 3 3
 */
public class Test2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            // System.out.println(k);
            int[][] A = new int[k][2];
            int[][] B = new int[k][2];
            for (int j = 0; j < k; j++) {
                A[j][0] = scanner.nextInt();
                A[j][1] = scanner.nextInt();
            }
            for (int j = 0; j < k; j++) {
                B[j][0] = scanner.nextInt();
                B[j][1] = scanner.nextInt();
            }
            System.out.println("...");
            // long[] res = new long[k];
            long res = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                long min = Long.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    long tmp = (A[j][0] - B[l][0]) * (A[j][0] - B[l][0])
                            + (A[j][1] - B[l][1]) * (A[j][1] - B[l][1]);
                    if (min > tmp) {
                        min = tmp;
                    }
                }
                if (res > min) {
                    res = min;
                }
            }

            /*double sqrt = Math.sqrt(res);
            sqrt *= 1000;
            long round = Math.round(sqrt);*/
            BigDecimal bigDecimal = BigDecimal.valueOf(res);
            System.out.println(bigDecimal.plus());
            // System.out.println(round / 1000 + "." + round % 1000);
        }
    }
}
