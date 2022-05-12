package com.coding.tasks.leetcode.second_round.google.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
}
