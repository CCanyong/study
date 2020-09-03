package qiniu;

import java.util.*;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 28/04/2020 19:20
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        int edges = scanner.nextInt();
        Set<Integer>[] sets = new HashSet[points + 1];
        for (int i = 0; i <= points; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < edges; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            sets[a].add(b);
            sets[b].add(a);
        }
        if (edges < points - 1) {
            System.out.println("NO");
            return;
        }
        if (points == 1) {
            System.out.println("YES");
            return;
        }
        sets[0] = sets[1];
        int[] arr = new int[points + 1];
        while (sets[0].size() != points) {
            boolean flag = false;
            for (int i = 2; i <= points; i++) {
                if (arr[i] == 0 && sets[0].contains(i)) {
                    sets[0].addAll(sets[i]);
                    arr[i] = 1;
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
