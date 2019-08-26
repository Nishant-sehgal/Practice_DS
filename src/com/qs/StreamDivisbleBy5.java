package com.qs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDivisbleBy5 {

	public static void main(String[] args) {
        String stream = "1101";
        List<Character> list = stream.chars().mapToObj(x -> Character.valueOf((char) x)).collect(Collectors.toList());
        isDiv5(list.stream());
    }

    static void isDiv5(Stream<Character> s) {
        final int[] res = new int[]{0};
        final StringBuilder sb = new StringBuilder();
        s.forEach(d -> {
            sb.append(d);
            int bv = Character.valueOf(d) - Character.valueOf('0');
            res[0] = res[0] * 2 + bv;
            res[0] = res[0] % 5;
            System.out.printf("%s is %s divisible by 5%n", sb.toString(), res[0] == 0 ? "" : "NOT");

        });
    }

}
