package com.coding.tasks.leetcode.second_round.google.interview_process;

public class LicenseKeyFormatting {

   public static void main(String[] args) {
      System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
      System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
   }

   private static String licenseKeyFormatting(String s, int k) {
      StringBuilder sb = new StringBuilder();
      char[] chars = s.toCharArray();
      int counter = 0;
      for (int i = chars.length - 1; i >= 0; i--) {
         String curr = chars[i] + "";
         if (!curr.equals("-")) {
            if (counter < k) {
               sb.append(curr);
               counter++;
            } else {
               counter = 1;
               sb.append("-").append(curr);
            }
         }
      }

      return sb.reverse().toString().toUpperCase();
   }
}
