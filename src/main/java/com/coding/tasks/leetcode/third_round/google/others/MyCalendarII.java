package com.coding.tasks.leetcode.third_round.google.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MyCalendarII {

   public static void main(String[] args) {

   }

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
