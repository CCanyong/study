package Bank;

import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 29/04/2020 09:32
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            if (arr[i] % 2 == 0) {
                if (arr[i + 1] == arr[i] + 1) {
                    continue;
                }
                for (int j = i + 1; j < 2 * n; j++) {
                    if (arr[j] == arr[i] + 1) {
                        int tmp = arr[j];
                        arr[j] = arr[i + 1];
                        arr[i + 1] = tmp;
                        res += 1;
                    }
                }
            }
            if (arr[i] % 2 == 1) {
                if (arr[i + 1] == arr[i] - 1) {
                    continue;
                }
                for (int j = i + 1; j < 2 * n; j++) {
                    if (arr[j] == arr[i] - 1) {
                        int tmp = arr[j];
                        arr[j] = arr[i + 1];
                        arr[i + 1] = tmp;
                        res += 1;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
