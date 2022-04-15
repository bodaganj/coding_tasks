package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindAndReplaceString {

   public static void main(String[] args) {
      System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
      System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
      System.out.println(findReplaceString("abcde", new int[]{2, 2}, new String[]{"cdef", "bc"}, new String[]{"f", "fe"}));

//      System.out.println(findReplaceString("wreorttvosuidhrxvmvo",
//                                           new int[]{14, 12, 10, 5, 0, 18},
//                                           new String[]{"rxv", "dh", "ui", "ttv", "wreor", "vo"},
//                                           new String[]{"frs", "c", "ql", "qpir", "gwbeve", "n"}));
//
//      System.out.println(findReplaceString("fvokzonyhukpwbnkomdianhirsvdulhsfseaqzktupyeverfsd",
//                                           new int[]{26, 30, 38, 2, 41, 10, 8, 44, 19, 4, 13, 28, 21, 35, 23, 16},
//                                           new String[]{"vd", "hsfs", "ktu", "ok", "pye", "kp", "hu", "verfs", "ia", "zon", "bnk", "ul", "nh", "aqz", "irs", "om"},
//                                           new String[]{"h", "gdlf", "nl", "sr", "xhn", "ax", "arf", "ifuax", "a", "mk", "vwqe", "fdl", "n", "miyr", "ibh", "den"}));
   }

   private static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
      Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
      for (int i = 0; i < indices.length; i++) {
         pq.offer(new int[]{indices[i], i});
      }

      int stringCounterShift = 0;
      int counter = 0;
      while (counter < indices.length) {
         int[] poll = pq.poll();

         int charIndex = poll[0];
         int allArraysIndex = poll[1];
         if (isStringPresent(s, charIndex + stringCounterShift, sources[allArraysIndex])) {
            s = s.substring(0, charIndex + stringCounterShift)
               + targets[allArraysIndex]
               + s.substring(charIndex + sources[allArraysIndex].length() + stringCounterShift);
            stringCounterShift += targets[allArraysIndex].length() - sources[allArraysIndex].length();
         }
         counter++;
      }

      return s;
   }

   private static boolean isStringPresent(String str, int index, String expected) {
      int counter = 0;
      while (counter < expected.length()) {
         if (index >= str.length() || str.charAt(index) != expected.charAt(counter)) {
            return false;
         }
         index++;
         counter++;
      }
      return true;
   }
}
