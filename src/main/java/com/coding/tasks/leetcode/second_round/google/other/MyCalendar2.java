package com.coding.tasks.leetcode.second_round.google.other;

import java.util.HashMap;
import java.util.Map;

public class MyCalendar2 {

   public static void main(String[] args) {
      MyCalendarTwo o = new MyCalendarTwo();
      System.out.println(o.book(10, 20));
      System.out.println(o.book(50, 60));
      System.out.println(o.book(10, 40));
      System.out.println(o.book(5, 15));
      System.out.println(o.book(5, 10));
      System.out.println(o.book(25, 55));
   }

   /**
    * Your MyCalendarTwo object will be instantiated and called as such:
    * MyCalendarTwo obj = new MyCalendarTwo();
    * boolean param_1 = obj.book(start,end);
    */
   static class MyCalendarTwo {

      private Map<Integer, Integer> map;

      public MyCalendarTwo() {
         map = new HashMap<>();
      }

      public boolean book(int start, int end) {
         for (int i = start; i < end; i++) {
            if (map.containsKey(i) && map.get(i) > 1) {
               return false;
            }
         }

         for (int i = start; i < end; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
         }

         return true;
      }
   }
}
