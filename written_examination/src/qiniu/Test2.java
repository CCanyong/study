package qiniu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 28/04/2020 19:45
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
