package com.coding.tasks.cracking.the.code.arrays.and.strings;

import java.util.List;
import java.util.stream.Collectors;

public class StringCompression {

   public static void main(String[] args) {
      System.out.println(compressString("Aaabcccccaaa"));
      System.out.println(compressString("abc"));
   }

   private static String compressString(String input) {
      List<Character> list = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

      int counter = 1;
      Character curr = input.charAt(0);
      StringBuilder stringBuilder = new StringBuilder();

      for (int i = 1; i < list.size(); i++) {
         Character character = list.get(i);
         if (character.equals(curr)) {
            counter++;
         } else {
            stringBuilder.append(curr).append(counter);
            curr = character;
            counter = 1;
         }
         if (i == list.size() - 1) {
            stringBuilder.append(curr).append(counter);
         }
      }
      String finalString = stringBuilder.toString();
      if (finalString.length() < input.length()) {
         return finalString;
      } else {
         return input;
      }
   }
}
