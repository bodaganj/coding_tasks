package com.coding.tasks.leetcode.google.interview_process;

public class LicenseKeyFormatting {

   public static void main(String[] args) {
      System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
      System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
   }

   private static String licenseKeyFormatting(String s, int k) {
      String stringWithoutDashes = s.replaceAll("-", "").toUpperCase();

      StringBuilder stringBuilder = new StringBuilder();

      char[] chars = stringWithoutDashes.toCharArray();
      int counter = 1;
      for(int index = chars.length - 1; index >= 0; index--) {
         stringBuilder.append(chars[index]);
         if (counter % k == 0 && index != 0) {
            stringBuilder.append("-");
         }
         counter++;
      }
      return stringBuilder.reverse().toString();
   }
}
