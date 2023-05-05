package com.zxp.sunday;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class Site{
    int x;
    int y;

    public Site(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSquare(){
        return x*x + y*y;
    }
}

public class Test1 {


    // allLocations : 一个元素列表 (x,y) 表示该素食餐厅的坐标
    // numsRestaurants : 表示将返回给客户x 的附近素食餐厅的数量
    public List<Site> function(List<Site> allLocations, int numRestaurants){
        // 建立最小堆
        PriorityQueue<Site> minHeap = new PriorityQueue<Site>((s1, s2) -> {
            int distance1 = s1.getSquare();
            int distance2 = s2.getSquare();
            if (distance1 != distance2){
                return distance1 -distance2 > 0 ? 1 : -1;
            }else if (s1.x != s2.x){
                return s1.x - s2.x > 0 ? 1 : -1;
            }
            return 0;
        });
        // 将所有元素全部放在最小堆中
        for (Site location : allLocations) {
            minHeap.offer(location);
        }
        // 找出 numRestaurants
        List<Site> res = new ArrayList<>();
        for (int i = 0; i < numRestaurants; i++) {
            res.add(minHeap.poll());
        }
        return res;
    }


    public static void main(String[] args) {
        List<Site> list = new ArrayList<>();
        list.add(new Site(1,2));
        list.add(new Site(3,4));
        list.add(new Site(1,-1));
        List<Site> function = new Test1().function(list, 2);
        for (Site site : function) {
            System.out.println(site.x + ":" + site.y);
        }
    }
}
