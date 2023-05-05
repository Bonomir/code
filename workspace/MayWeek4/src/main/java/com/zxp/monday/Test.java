package com.zxp.monday;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;

import java.util.Arrays;

public class Test {

    static ThreadLocal<Integer[]> local = new ThreadLocal<>();

    public static void main(String[] args) {
        final int arg = 0;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer[] arr = {1,2,3};
                local.set(arr);
                task();
            }
        });
        t1.start();
    }

    private static void task() {
        // 如果之后的方法里使用到参数，那么需要继续传毒
        task1();
    }

    private static void task1() {
        System.out.println(Arrays.toString(local.get()));
    }
}
