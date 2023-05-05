package com.zxp.sunday;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int size;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        size = nums.length;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < size){
            minHeap.offer(val);
        }else if (val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
