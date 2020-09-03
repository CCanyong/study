package Bank;

import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 29/04/2020 09:01
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
            }
        }
        System.out.println(arr[0][0]);
    }

    /*public static int dfs(int[][] arr, int i, int j) {
        if (j < 0 || j > i) {
            return 0;
        }
        if (i == n - 1) {
            return arr[i][j];
        }
        return arr[i][j] + Math.max(dfs(arr, i + 1, j), dfs(arr, i + 1, j + 1));
    }*/
}
