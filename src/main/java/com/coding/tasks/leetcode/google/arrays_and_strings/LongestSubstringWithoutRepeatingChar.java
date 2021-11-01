package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingChar {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(""));
      System.out.println(lengthOfLongestSubstring(" "));
      System.out.println(lengthOfLongestSubstring("dvdf"));
   }

   private static int lengthOfLongestSubstring(String s) {
      if (Objects.isNull(s) || s.isEmpty()) {
         return 0;
      }

      int max = 0;
      List<Character> input = s.chars().mapToObj(obj -> (char) obj).collect(Collectors.toList());
      Queue<Character> queue = new LinkedList<>();

      for (Character letter : input) {
         if (queue.contains(letter)) {
            max = Math.max(max, queue.size());
            while (!queue.isEmpty()) {
               Character poll = queue.poll();
               if (poll == null || poll.equals(letter)) {
                  break;
               }
            }
            queue.add(letter);
         } else {
            queue.add(letter);
            max = Math.max(max, queue.size());
         }
      }
      return max;
   }
}
