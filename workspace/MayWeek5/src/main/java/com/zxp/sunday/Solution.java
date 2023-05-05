package com.zxp.sunday;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        // 随机半径长度
        double len = Math.sqrt(random.nextDouble() * radius * radius );
        // 随机角度 [0,2Π]
        double ang = random.nextDouble() * 2 * Math.PI;
        // 园内随机求一点的 x坐标
        double randomX = x_center + len * Math.cos(ang);
        // 园内随机求一点的 y坐标
        double randomY = y_center + len * Math.sin(ang);
        return new double[]{randomX,randomY};
    }


    public static void main(String[] args) {
        Solution solution = new Solution(10, 5, -7.5);
        double[] doubles1 = solution.randPoint();
        System.out.println(Arrays.toString(doubles1));
        double[] doubles2 = solution.randPoint();
        System.out.println(Arrays.toString(doubles2));
        double[] doubles3 = solution.randPoint();
        System.out.println(Arrays.toString(doubles3));
    }
}
