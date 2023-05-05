package com.zxp.sunday;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer,Integer> myCalendar;

    public MyCalendar() {
       myCalendar =  new TreeMap<Integer,Integer>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> event = myCalendar.floorEntry(start);
        if(event != null && event.getValue() > start){
            return false;
        }
        event = myCalendar.ceilingEntry(start);
        if(event != null && event.getValue() < end){
            return false;
        }
        myCalendar.put(start,end);
        return true;
    }

    public static void main(String[] args) {
        new MyCalendar().book(1,2);
    }
}
