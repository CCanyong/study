package yy;

import java.util.Scanner;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 31/08/2020 19:08
 */
public class YYTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // aabcaabcdaaad
        // 2(aabc)1(d)3(a)1(d)
        String str = "aabcaabcdaaad";// sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        StringBuilder res = new StringBuilder();
        while (sb.length() > 0) {
            int index = sb.length() / 2;
            int times = 0;
            while (index > 0){
                String tmp = null;
                if (sb.substring(0,index).equals(sb.substring(index, index * 2))){
                    times = 2;
                    tmp = sb.substring(0,index);
                    sb.delete(0, index * 2);
                    while (sb.length() > index && sb.substring(0,index).equals(tmp)) {
                        times ++;
                        sb.delete(0,index);
                    }
                    res.append(times).append('(').append(tmp).append(')');
                    break;
                } else {
                    index --;
                }
            }
            if (index == 0) {
                res.append(1).append('(').append(sb.substring(0,1)).append(')');
                sb.deleteCharAt(0);
            }
        }
        System.out.println(res.toString());
    }
}
