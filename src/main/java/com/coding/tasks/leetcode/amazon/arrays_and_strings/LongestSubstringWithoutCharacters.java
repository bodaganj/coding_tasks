package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongestSubstringWithoutCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(" "));
   }

   private static int lengthOfLongestSubstring(String s) {
      int longestSubstring = 0;

      if (!Objects.isNull(s) && !s.isEmpty()) {
         for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int j = i;
            while (j < s.length() && set.add(s.charAt(j))) {
               longestSubstring = Math.max(longestSubstring, set.size());
               j++;
            }
         }
      }
      return longestSubstring;
   }

   // this one is better!!!!!
//   public int lengthOfLongestSubstring1(String s) {
//      if (Objects.isNull(s) || s.isEmpty()) {
//         return 0;
//      }
//
//      int max = 0;
//      List<Character> input = s.chars().mapToObj(obj -> (char) obj).collect(Collectors.toList());
//      Queue<Character> queue = new LinkedList<>();
//
//      for (Character letter : input) {
//         if (queue.contains(letter)) {
//            max = Math.max(max, queue.size());
//            while (!queue.isEmpty()) {
//               Character poll = queue.poll();
//               if (poll == null || poll.equals(letter)) {
//                  break;
//               }
//            }
//            queue.add(letter);
//         } else {
//            queue.add(letter);
//            max = Math.max(max, queue.size());
//         }
//      }
//      return max;
//   }
}
