package tx;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 26/04/2020 20:28
 */
public class test5 {


    public static void main(String[] args) {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String cmd = scanner.nextLine();
            String[] arr = cmd.split(" ");
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            switch (arr[0]) {
                case "add":
                    in.push(Integer.valueOf(arr[1]));
                    break;
                case "peek":
                    if (out.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(out.peek());
                    }
                    break;
                case "poll":
                    if (out.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        out.pop();
                    }
                    break;
            }
        }
    }
}
