package tx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 26/04/2020 20:46
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Long> map = new HashMap<>();
        long tmp = 1;
        for (int i = 1; i <= 60; i++) {
            tmp = tmp * 2;
            map.put(i, tmp);
        }
        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();
            int k = scanner.nextInt();
            if (k == 1) {
                System.out.println(1);
                continue;
            }
            Long aLong = map.get(k);
            if (aLong > num) {
                System.out.println(-1);
            } else {
                while (num >= aLong) {
                    num = num / 2;
                }
                System.out.println(num);
            }
        }
    }
}
