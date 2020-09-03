package xuersi;

import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 07/05/2020 19:23
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        if(i == s.length() || s.charAt(i) < '0' || s.charAt(i) > '9'){
            System.out.println("0-0");
            return;
        }
        System.out.print("1-");
        for (; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            System.out.print(s.charAt(i));
        }
        System.out.println();

    }
}
