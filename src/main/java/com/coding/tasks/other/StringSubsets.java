package com.coding.tasks.other;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringSubsets {

   // ""
   // a
   // aa
   // aab
   // aabc
   // aac
   // ab
   // abc
   // ac
   // b
   // bc
   // c

   public static void main(String[] args) {
      stringSubset("aabc");
   }

   public static void stringSubset(String str) {
      Set<String> set = new LinkedHashSet<>();
      rec("", str, set);
      System.out.println(set);
   }

   private static void rec(String current, String str, Set<String> set) {
      set.add(current);

      for (int i = 0; i < str.length(); i++) {
         rec(current + str.charAt(i), str.substring(i + 1), set);
      }
   }
}
