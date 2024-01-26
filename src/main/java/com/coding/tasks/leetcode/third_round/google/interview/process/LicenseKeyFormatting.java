package com.coding.tasks.leetcode.third_round.google.interview.process;

public class LicenseKeyFormatting {

   public static void main(String[] args) {

   }

   public static String licenseKeyFormatting(String s, int k) {
      StringBuilder sb = new StringBuilder();
      int groupCounter = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
         char curr = s.charAt(i);
         if (Character.isLetter(curr) || Character.isDigit(curr)) {
            if (groupCounter == k) {
               sb.append("-");
               groupCounter = 0;
            }

            groupCounter++;
            sb.append(String.valueOf(curr).toUpperCase());
         }
      }
      return sb.reverse().toString();
   }
}
