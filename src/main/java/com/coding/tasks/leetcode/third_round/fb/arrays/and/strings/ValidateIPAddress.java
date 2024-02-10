package com.coding.tasks.leetcode.third_round.fb.arrays.and.strings;

import java.util.Set;

public class ValidateIPAddress {

   public static void main(String[] args) {
//      System.out.println(validIPAddress("2001:0db8:85a3:0::0:8A2E:0370:7334:"));
      System.out.println(validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
   }

   public static String validIPAddress(String queryIP) {
      if (queryIP == null || queryIP.isEmpty()) {
         return "Neither";
      }
      if (isIp4(queryIP)) {
         return "IPv4";
      } else if (isIp6(queryIP)) {
         return "IPv6";
      } else {
         return "Neither";
      }
   }

   private static boolean isIp4(String str) {
      if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') {
         return false;
      }
      String[] split = str.split("\\.");
      if (split.length == 4) {
         for (String s : split) {
            if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) {
               return false;
            }
            try {
               int i = Integer.parseInt(s);
               if (i > 255 || i < 0) {
                  return false;
               }
            } catch (NumberFormatException ex) {
               return false;
            }
         }
      } else {
         return false;
      }
      return true;
   }

   private static boolean isIp6(String str) {
      if (str.charAt(0) == ':' || str.charAt(str.length() - 1) == ':') {
         return false;
      }
      Set<Character> set = Set.of('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F');

      String[] split = str.split(":");
      if (split.length == 8) {
         for (String s : split) {
            if (s.isEmpty() || s.length() > 4) {
               return false;
            }
            for (char c : s.toCharArray()) {
               if (Character.isLetter(c) && !set.contains(c)) {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
      return true;
   }
}
