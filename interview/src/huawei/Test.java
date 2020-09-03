package huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 02/09/2020 11:11
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        PriorityQueue<Integer> res = new PriorityQueue<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                res.add(c - '0');
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.poll() + ", ");
        }
    }
}
