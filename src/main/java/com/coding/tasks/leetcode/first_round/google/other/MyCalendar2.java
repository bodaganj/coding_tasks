package com.coding.tasks.leetcode.first_round.google.other;

import java.util.HashMap;
import java.util.Map;

public class MyCalendar2 {

   /**
    * Your MyCalendarTwo object will be instantiated and called as such:
    * MyCalendarTwo obj = new MyCalendarTwo();
    * boolean param_1 = obj.book(start,end);
    */
   static class MyCalendarTwo {

      private Map<Integer, Integer> map;

      public MyCalendarTwo() {
         this.map = new HashMap<>();
      }

      public boolean book(int start, int end) {
         for (int i = start; i < end; i++) {
            if (map.containsKey(i)) {
               if (map.get(i) == 2) {
                  for (int j = start; j < i; j++) {
                     map.put(j, 1);
                  }
                  return false;
               } else {
                  map.put(i, 2);
               }
            } else {
               map.put(i, 1);
            }
         }

         return true;
      }
   }
}
