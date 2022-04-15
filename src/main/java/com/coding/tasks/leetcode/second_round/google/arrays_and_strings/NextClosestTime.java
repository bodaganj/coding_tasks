package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextClosestTime {

   public static void main(String[] args) {
      System.out.println(nextClosestTime("19:34")); // 19:39
      System.out.println(nextClosestTime("23:59")); // 22:22
      System.out.println(nextClosestTime("13:55")); // 15:11
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
      if (Integer.parseInt("" + current.charAt(1)) < all.get(all.size() - 1)) { // increase last digit for mins
         int potentialFirstMinDigit = -1;
         for (Integer integer : all) {
            if (integer > Integer.parseInt("" + current.charAt(1))) {
               potentialFirstMinDigit = integer;
               break;
            }
         }
         return "" + current.charAt(0) + potentialFirstMinDigit;
      } else { // increase first digit for mins
         int potentialFirstMinDigit = -1;
         for (Integer integer : all) {
            if (integer > Integer.parseInt("" + current.charAt(0))) {
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
      if (Integer.parseInt("" + current.charAt(0)) == 0) {
         if (Integer.parseInt("" + current.charAt(1)) < all.get(all.size() - 1)) {
            int potentialFirstMinDigit = -1;
            for (Integer integer : all) {
               if (integer > Integer.parseInt("" + current.charAt(1))) {
                  potentialFirstMinDigit = integer;
                  break;
               }
            }
            return "" + current.charAt(0) + potentialFirstMinDigit;
         } else {
            if (all.contains(1)) {
               return "" + 1 + all.get(0);
            } else if (all.contains(2)) {
               return "" + 2 + all.get(0);
            } else {
               return "" + all.get(0) + all.get(0);
            }
         }
      } else if (Integer.parseInt("" + current.charAt(0)) == 1) {
         if (Integer.parseInt("" + current.charAt(1)) < all.get(all.size() - 1)) {
            int potentialFirstMinDigit = -1;
            for (Integer integer : all) {
               if (integer > Integer.parseInt("" + current.charAt(1))) {
                  potentialFirstMinDigit = integer;
                  break;
               }
            }
            return "" + current.charAt(0) + potentialFirstMinDigit;
         } else {
            if (all.contains(2)) {
               return "" + 2 + all.get(0);
            } else {
               return "" + all.get(0) + all.get(0);
            }
         }
      } else {
         if (Integer.parseInt("" + current.charAt(1)) < all.get(all.size() - 1)) {
            int potentialFirstMinDigit = -1;
            for (Integer integer : all) {
               if (integer > Integer.parseInt("" + current.charAt(1))) {
                  potentialFirstMinDigit = integer;
                  break;
               }
            }
            if (potentialFirstMinDigit < 4 && potentialFirstMinDigit >= 0) {
               return "" + current.charAt(0) + potentialFirstMinDigit;
            } else {
               return "" + all.get(0) + all.get(0);
            }
         } else {
            return "" + all.get(0) + all.get(0);
         }
      }
   }
}
