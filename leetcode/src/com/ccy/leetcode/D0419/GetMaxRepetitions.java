package com.ccy.leetcode.D0419;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 19/04/2020 23:38
 */
public class GetMaxRepetitions {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1.equals(s2)) {
            return n1 / n2;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int t1 = 0;
        int t2 = 0;
        int k = 0;
        while (s1.charAt(k) != s2.charAt(0)) {
            k++;
        }
        int i = 1;
        int j = k + 1;
        boolean flag = false;
        while (true) {
            flag = false;
            while (s1.charAt(j) != s2.charAt(i)) {
                j++;
                if (j % len1 == 0) {
                    flag = true;
                    j = 0;
                    t1++;
                    if (t1 >= n1) {
                        return t2 / n2;
                    }
                }
            }
            // System.out.println(i + "   " + j + "   "+k );
            if (i == 0 && j == k) {
                break;
            }
            i++;
            j++;
            if (j % len1 == 0) {
                j = 0;
                t1++;
                if (t1 >= n1) {
                    return t2 / n2;
                }
            }
            if (i % len2 == 0) {
                i = 0;
                t2++;
            }
        }
        System.out.println(t1 + "..." + t2);
        if (t1 < n1) {
            int l = n1 % t1;
            t2 = t2 * (n1 / t1);
            // System.out.println(t2);
            int q = n1 % t1;
            if (q == 0) {
                if (flag) {
                    return t2 / n2;
                } else {
                    return (t2 - 1) / n2;
                }
            } else {
                i = 0;
                j = 0;
                while (q > 0) {
                    while (s1.charAt(j) != s2.charAt(i)) {
                        j++;
                        if (j % len1 == 0) {
                            q--;
                            j = 0;
                        }
                    }
                    i++;
                    j++;
                    if (j % len1 == 0) {
                        q--;
                        j = 0;
                    }
                    if (i % len2 == 0) {
                        t2++;
                        i = 0;
                    }
                }
                // System.out.println(t2);
                return t2 / n2;
            }
        } else if (t1 == n1) {
            return t2 / n2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikef";
        String s2 = "fmznimkkasvwsrenzkycxfxtlsgypsfad";
        System.out.println(new GetMaxRepetitions().getMaxRepetitions(s1, 1000000, s2, 333));
    }
}
