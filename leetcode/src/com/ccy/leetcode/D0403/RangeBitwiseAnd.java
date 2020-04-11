package com.ccy.leetcode.D0403;

public class RangeBitwiseAnd {


    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while (n!=0){
            if(m == n){
                return (m & n) << res;
            }
            n = n >> 1;
            m = n >> 1;
            res ++;
        }
        return 0;
    }





    public int func1(int m, int n) {
        if(n-m > m){
            return 0;
        }
        if(m==n){
            return n;
        }
        int res = m;
        while(m <= n){
            res = res & (m++) & (n--);
        }
        return res;
    }
}
