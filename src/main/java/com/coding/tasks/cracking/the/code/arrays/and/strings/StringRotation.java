package com.coding.tasks.cracking.the.code.arrays.and.strings;

public class StringRotation {

   // waterbottle and erbottlewaterbottlewat
   // bback and backbbackb
   private static boolean isRotation(String s1, String s2) {
      return isSubstring(s1 + s1, s2);
   }

   private static boolean isSubstring(String s1, String s2) {
      return true;
   }
}
