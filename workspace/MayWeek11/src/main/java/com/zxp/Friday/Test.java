package com.zxp.Friday;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        System.out.print(sb.reverse());
    }
}
