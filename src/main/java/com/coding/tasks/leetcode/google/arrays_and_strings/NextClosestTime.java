package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

   public static void main(String[] args) {
      System.out.println(nextClosestTime("19:34"));
      System.out.println(nextClosestTime("23:59"));
   }

   private static String nextClosestTime(String time) {
      Set<Integer> set = new HashSet<>();
      set.add(time.charAt(0) - '0');
      set.add(time.charAt(1) - '0');
      set.add(time.charAt(3) - '0');
      set.add(time.charAt(4) - '0');

      int hours = Integer.parseInt(time.substring(0, 2));
      int mins = Integer.parseInt(time.substring(3));

      while (true) {
         mins++;
         hours = (hours + mins / 60) % 24;
         mins = mins % 60;
         if (set.contains(hours / 10) &&
            set.contains(hours % 10) &&
            set.contains(mins / 10) &&
            set.contains(mins % 10)) {
            break;
         }
      }
      return String.format("%02d", hours) + ":" + String.format("%02d", mins);
   }

   // ANOTHER ONE!!!!!
//   public String nextClosestTime(String time) {
//      char[] result = time.toCharArray();
//      char[] digits = new char[] {result[0], result[1], result[3], result[4]};
//      Arrays.sort(digits);
//
//      // find next digit for HH:M_
//      result[4] = findNext(result[4], (char)('9' + 1), digits);  // no upperLimit for this digit, i.e. 0-9
//      if(result[4] > time.charAt(4)) return String.valueOf(result);  // e.g. 23:43 -> 23:44
//
//      // find next digit for HH:_M
//      result[3] = findNext(result[3], '5', digits);
//      if(result[3] > time.charAt(3)) return String.valueOf(result);  // e.g. 14:29 -> 14:41
//
//      // find next digit for H_:MM
//      result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char)('9' + 1), digits);
//      if(result[1] > time.charAt(1)) return String.valueOf(result);  // e.g. 02:37 -> 03:00
//
//      // find next digit for _H:MM
//      result[0] = findNext(result[0], '2', digits);
//      return String.valueOf(result);  // e.g. 19:59 -> 11:11
//   }
//
//   /**
//    * find the next bigger digit which is no more than upperLimit.
//    * If no such digit exists in digits[], return the minimum one i.e. digits[0]
//    * @param current the current digit
//    * @param upperLimit the maximum possible value for current digit
//    * @param digits[] the sorted digits array
//    * @return
//    */
//   private char findNext(char current, char upperLimit, char[] digits) {
//      //System.out.println(current);
//      if(current == upperLimit) {
//         return digits[0];
//      }
//      int pos = Arrays.binarySearch(digits, current) + 1;
//      while(pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) { // traverse one by one to find next greater digit
//         pos++;
//      }
//      return pos == 4 ? digits[0] : digits[pos];
//   }
}