package com.zxp.wednesday;

import java.util.*;

/**
 * 380:O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {
    // 存放元素
    List<Integer> nums;
    // 记录每个元素的下标，从0开始
    Map<Integer, Integer> indices;
    // 创建 random对象，用来获取随机数
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        // nums数组包含直接返回false
        if (indices.containsKey(val)) {
            return false;
        }
        // 不包含，插入进去
        int index  = nums.size(); // 当前有多少个元素，第一个就是 0
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)){
            return false;
        }
        Integer index = indices.get(val);
        Integer last = nums.get(nums.size() - 1); // 集合中最后一个元素
        // 找到最后一个元素，把他插入到待删除元素位置上，然后删除最后一个元素
        nums.set(index, last);
        indices.put(last,index);
        // 删除最后一个元素(不是last所指向的元素，利用下标删除)
        nums.remove(nums.size()-1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}
