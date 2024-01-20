package com.coding.tasks.leetcode.third_round.top_interview_questions.google.arrays.and.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {

   public static void main(String[] args) {
//      System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
      System.out.println(findReplaceString("vmokgggqzp",
                                           new int[]{3, 5, 1},
                                           new String[]{"kg", "ggq", "mo"},
                                           new String[]{"s", "so", "bfr"}));
      System.out.println(findReplaceString("abcdef",
                                           new int[]{2, 2},
                                           new String[]{"feg", "cdef"},
                                           new String[]{"abc", "feg"}));
   }

   public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
      List<Pair> indicesList = new ArrayList<>();
      for (int i = 0; i < indices.length; i++) {
         indicesList.add(new Pair(indices[i], i));
      }
      indicesList.sort(Comparator.comparingInt(Pair::value));

      StringBuilder sb = new StringBuilder();

      for (int i = indicesList.size() - 1; i >= 0; i--) {
         int index = indicesList.get(i).index;
         if (s.startsWith(sources[index], indicesList.get(i).value)) {
            s = s.substring(0, indicesList.get(i).value) + targets[index] + s.substring(indicesList.get(i).value + sources[index].length());
         }
      }
      return s;
   }

   private record Pair(int value, int index) {

   }
}
