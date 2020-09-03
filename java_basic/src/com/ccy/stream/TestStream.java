package com.ccy.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 27/04/2020 11:39
 */
public class TestStream {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.stream().filter(i -> i > 10);

    }
}
