package Bank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 29/04/2020 10:02
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int topKSum = 0;
        for (int i = 0; i < k; i++) {
            topKSum += arr[i];
        }
        int finalKSum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            topKSum += arr[i];
        }
        return ;
    }
}
