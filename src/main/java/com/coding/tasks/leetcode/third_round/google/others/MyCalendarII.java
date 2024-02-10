package com.coding.tasks.leetcode.third_round.google.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MyCalendarII {

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
    * Sort all booking by x coordinate and isOpen boolean flag. E.g.: [10, open], [15, open], [20, close], [25, open], [25, close], [55, close]
    * When trying to book. Add nes booking to list. Sort the list and then in loop for all coordinates:
    * 1. if open - add to stack
    * 2. if close - remove from stack
    * return false, if stack size > 2 (don't forget to remove newStart and newEnd from the list. This booking is failed.)
    * return true at the end
    */
   static class MyCalendarTwo {

      private List<Time> list;

      public MyCalendarTwo() {
         list = new ArrayList<>();
      }

      // N^2 logN
      public boolean book(int start, int end) {
         Time newStart = new Time(start, true);
         Time newEnd = new Time(end, false);

         list.add(newStart);
         list.add(newEnd);
         Collections.sort(list);
         Stack<Integer> stack = new Stack<>();
         for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isStart) {
               stack.push(i);
            } else {
               stack.pop();
            }

            if (stack.size() > 2) {
               list.remove(newStart);
               list.remove(newEnd);
               return false;
            }
         }
         return true;
      }

      static class Time implements Comparable<Time> {

         public int time;
         public boolean isStart;

         public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
         }

         @Override
         public int compareTo(Time o) {
            return this.time == o.time ? (this.isStart == o.isStart ? 0 : (isStart ? 1 : -1)) : this.time - o.time;
         }
      }
   }

   /**
    * Similar solution to above
    */
//   static class MyCalendarTwo {
//
//      private final TreeMap<Integer, Integer> map;
//
//      public MyCalendarTwo() {
//         map = new TreeMap<>();
//      }
//
//      public boolean book(int start, int end) {
//         map.put(start, map.getOrDefault(start, 0) + 1);
//         map.put(end, map.getOrDefault(end, 0) - 1);
//         int count = 0;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            count += entry.getValue();
//            if (count > 2) {
//               map.put(start, map.get(start) - 1);
//               if (map.get(start) == 0) {
//                  map.remove(start);
//               }
//               map.put(end, map.get(end) + 1);
//               if (map.get(end) == 0) {
//                  map.remove(end);
//               }
//               return false;
//            }
//         }
//         return true;
//      }
//   }

   /**
    * We have 2 arrays:
    * 1 - for all the bookings
    * 2 - for tracking all the overlaps for current new slot
    * <p>
    * How it works:
    * 1. Go through the whole list of existed bookings
    * 2. Check if new booking (start, end) overlaps current existed booking from the list: should be true if overlap - Math.max(booking[0], start) < Math.min(booking[1], end)
    * 3. If false - just add new booking to the list
    * 4. If true - go through the list of previously calculated overlaps or just add if it is the first overlap for new booking
    * 5. If this overlap overlaps existed previous overlap from the list (so this is tripple overlap), then clear the list of overlaps and return false
    * 6. Add overlap to the list, if this is not tripple overlap
    * 7. Return true at the end
    */
//   static class MyCalendarTwo {
//
//      private final List<int[]> bookings;
//      private final List<int[]> overlaps;
//
//      public MyCalendarTwo() {
//         bookings = new ArrayList<>();
//         overlaps = new ArrayList<>();
//      }
//
//      public boolean book(int start, int end) {
//         for (int[] booking : bookings) {
//            int overlapStart = Math.max(booking[0], start);
//            int overlapEnd = Math.min(booking[1], end);
//            if (overlapStart < overlapEnd) {
//               for (int[] overlap : overlaps) {
//                  if (Math.max(overlap[0], overlapStart) < Math.min(overlap[1], overlapEnd)) {
//                     overlaps.clear();
//                     return false;
//                  }
//               }
//               overlaps.add(new int[]{overlapStart, overlapEnd});
//            }
//         }
//         bookings.add(new int[]{start, end});
//         return true;
//      }
//   }
}
