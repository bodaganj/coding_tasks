package com.coding.tasks.leetcode.google.interview_process;

public class LicenseKeyFormatting {

   public static void main(String[] args) {
      System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
      System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
   }

   private static String licenseKeyFormatting(String s, int k) {
      String str = s.replaceAll("-", "").toUpperCase();
      StringBuilder sb = new StringBuilder();
      int counter = 0;
      for (int i = str.length() - 1; i >= 0; i--) {
         if (counter % k == 0 && counter != 0) {
            sb.append("-");
         }
         sb.append(str.charAt(i));
         counter++;
      }
      return sb.reverse().toString();
   }
}
