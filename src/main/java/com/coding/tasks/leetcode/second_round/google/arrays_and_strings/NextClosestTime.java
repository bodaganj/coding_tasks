package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class NextClosestTime {

   public static void main(String[] args) {
      System.out.println(nextClosestTime("19:34")); // 19:39
      System.out.println(nextClosestTime1("19:34")); // 19:39
      System.out.println(nextClosestTime("23:59")); // 22:22
      System.out.println(nextClosestTime1("23:59")); // 22:22
      System.out.println(nextClosestTime("13:55")); // 15:11
      System.out.println(nextClosestTime1("13:55")); // 15:11
   }

   private static String nextClosestTime1(String time) {
      char[] res = time.toCharArray();
      TreeSet<Character> set = new TreeSet<>(Arrays.asList(res[0], res[1], res[3], res[4]));

      res[4] = next(set, res[4], '9');
      if (time.charAt(4) < res[4]) {
         return new String(res);
      }

      res[3] = next(set, res[3], '5');
      if (time.charAt(3) < res[3]) {
         return new String(res);
      }

      res[1] = next(set, res[1], res[0] == '2' ? '3' : '9');
      if (time.charAt(1) < res[1]) {
         return new String(res);
      }

      res[0] = next(set, res[0], '2');
      return new String(res);
   }

   private static char next(TreeSet<Character> set, char c, char limit) {
      Character n = set.higher(c);
      return n == null || n > limit ? set.first() : n;
   }

   private static String nextClosestTime(String time) {
      List<Integer> all = new ArrayList<>();
      for (char aChar : time.toCharArray()) {
         if (Character.isDigit(aChar)) {
            all.add(Integer.parseInt(aChar + ""));
         }
      }
      Collections.sort(all);

      String[] split = time.split(":");
      String mins = getClosestMinutes(split[1], all);
      if (isGreater(split[1], mins)) {
         return split[0] + ":" + mins;
      } else {
         String hours = getClosestHours(split[0], all);
         return hours + ":" + mins;
      }
   }

   private static String getClosestMinutes(String current, List<Integer> all) {
      int secondInt = Integer.parseInt("" + current.charAt(1));
      int firstInt = Integer.parseInt("" + current.charAt(0));

      int potentialFirstMinDigit = -1;
      if (secondInt < all.get(all.size() - 1)) { // increase last digit for mins
         for (Integer integer : all) {
            if (integer > secondInt) {
               potentialFirstMinDigit = integer;
               break;
            }
         }
         return "" + firstInt + potentialFirstMinDigit;
      } else { // increase first digit for mins
         for (Integer integer : all) {
            if (integer > firstInt) {
               potentialFirstMinDigit = integer;
               break;
            }
         }
         if (potentialFirstMinDigit < 6 && potentialFirstMinDigit >= 0) {
            return "" + potentialFirstMinDigit + all.get(0);
         } else {
            return "" + all.get(0) + all.get(0);
         }
      }
   }

   private static boolean isGreater(String current, String next) {
      return Integer.parseInt(next) > Integer.parseInt(current);
   }

   private static String getClosestHours(String current, List<Integer> all) {
      int secondInt = Integer.parseInt("" + current.charAt(1));
      int firstInt = Integer.parseInt("" + current.charAt(0));

      if (firstInt == 0) {
         if (secondInt < all.get(all.size() - 1)) {
            int potentialFirstMinDigit = -1;
            for (Integer integer : all) {
               if (integer > secondInt) {
                  potentialFirstMinDigit = integer;
                  break;
               }
            }
            return "" + firstInt + potentialFirstMinDigit;
         } else {
            if (all.contains(1)) {
               return "" + 1 + all.get(0);
            } else if (all.contains(2)) {
               return "" + 2 + all.get(0);
            } else {
               return "" + all.get(0) + all.get(0);
            }
         }
      } else if (firstInt == 1) {
         if (secondInt < all.get(all.size() - 1)) {
            int potentialFirstMinDigit = -1;
            for (Integer integer : all) {
               if (integer > secondInt) {
                  potentialFirstMinDigit = integer;
                  break;
               }
            }
            return "" + firstInt + potentialFirstMinDigit;
         } else {
            if (all.contains(2)) {
               return "" + 2 + all.get(0);
            } else {
               return "" + all.get(0) + all.get(0);
            }
         }
      } else {
         if (secondInt < all.get(all.size() - 1)) {
            int potentialFirstMinDigit = -1;
            for (Integer integer : all) {
               if (integer > secondInt) {
                  potentialFirstMinDigit = integer;
                  break;
               }
            }
            if (potentialFirstMinDigit < 4 && potentialFirstMinDigit >= 0) {
               return "" + firstInt + potentialFirstMinDigit;
            } else {
               return "" + all.get(0) + all.get(0);
            }
         } else {
            return "" + all.get(0) + all.get(0);
         }
      }
   }
}
