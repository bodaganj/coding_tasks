package com.coding.tasks.cracking.the.code.arrays_and_strings;

import java.util.Arrays;
import java.util.Objects;

public class Urlify {

   public static void main(String[] args) {
      String[] input = new String[]{"M", "r", " ", "J", "o", "h", "n", " ", "S", "m", "i", "t", "h", " ", " ", " ", " ", " ", " "};
      System.out.println(Arrays.toString(getUrl(input, 13)));
   }

   /**
    * Write a method to replace all spaces in a string with "%20". You are giving a true length of the string
    * @param input
    * @return
    */
   private static String[] getUrl(String[] input, int length) {
      for (int i = 0; i < length; i++) {
         if (Objects.equals(input[i], " ")) {
            input[i] = "%20";
         }
      }
      return Arrays.copyOfRange(input, 0, length);
   }
}
