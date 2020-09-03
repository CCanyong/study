package GBit;

import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 28/04/2020 20:27
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        if (s1[0].length() <= s1[1].length()) {
            if (s1[0].equals(s1[1])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }
        char c = s1[1].charAt(0);
        int res = 0;
        for (int i = 0; i < s1[0].length(); i++) {
            if (s1[0].charAt(i) == c) {
                res = i + 1;
                break;
            }
        }
        if (s1[0].length() - res < s1[1].length()) {
            System.out.println(0);
            return;
        }
        boolean flag = true;
        int tmp = res;
        for (int i = 0; i < s1[1].length(); i++) {
            int j = tmp;
            for (; j < s1[0].length(); j++) {
                if (s1[0].charAt(j) == s1[1].charAt(i)) {
                    tmp = j + 1;
                    break;
                }
            }
            if (tmp <= j) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(res);

    }
}
