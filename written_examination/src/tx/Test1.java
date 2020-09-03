package tx;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 26/04/2020 20:03
 */
public class Test1 {

    private static final String PUSH = "PUSH";
    private static final String TOP = "TOP";
    private static final String SIZE = "SIZE";
    private static final String POP = "POP";
    private static final String CLEAR = "CLEAR";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            int k = Integer.valueOf(scanner.nextLine());
            for (int j = 0; j < k; j++) {
                String s = scanner.nextLine();
                String[] cmd = s.split(" ");
                if (cmd.length != 0) {
                    switch (cmd[0]) {
                        case PUSH:
                            if (cmd.length == 2) {
                                queue.addLast(Integer.valueOf(cmd[1]));
                            }
                            break;
                        case TOP:
                            if (queue.size() == 0) {
                                System.out.println(-1);
                            } else {
                                System.out.println(queue.getFirst());
                            }
                            break;
                        case SIZE:
                            System.out.println(queue.size());
                            break;
                        case CLEAR:
                            queue.clear();
                            break;
                        case POP:
                            if (queue.size() == 0) {
                                System.out.println(-1);
                            } else {
                                System.out.println(queue.getFirst());
                                queue.removeFirst();
                            }
                            break;
                    }
                }
            }
            queue.clear();
        }
    }

}

