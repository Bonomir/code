package com.zxp.Tursday;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strings = line.split("[ |    ]");
            String string1 = strings[0];
            int a = Integer.parseInt(string1);
            String string2 = strings[1];
            int b = Integer.parseInt(string2);
            int sum = a + b;
            System.out.println(sum);
        }
    }
}
