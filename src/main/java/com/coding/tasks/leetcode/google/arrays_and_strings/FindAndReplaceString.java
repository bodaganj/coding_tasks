package com.coding.tasks.leetcode.google.arrays_and_strings;

public class FindAndReplaceString {

   public static void main(String[] args) {
      System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
      System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));

      System.out.println(findReplaceString("wreorttvosuidhrxvmvo",
                                           new int[]{14, 12, 10, 5, 0, 18},
                                           new String[]{"rxv", "dh", "ui", "ttv", "wreor", "vo"},
                                           new String[]{"frs", "c", "ql", "qpir", "gwbeve", "n"}));

      System.out.println(findReplaceString("fvokzonyhukpwbnkomdianhirsvdulhsfseaqzktupyeverfsd",
                                           new int[]{26, 30, 38, 2, 41, 10, 8, 44, 19, 4, 13, 28, 21, 35, 23, 16},
                                           new String[]{"vd", "hsfs", "ktu", "ok", "pye", "kp", "hu", "verfs", "ia", "zon", "bnk", "ul", "nh", "aqz", "irs", "om"},
                                           new String[]{"h", "gdlf", "nl", "sr", "xhn", "ax", "arf", "ifuax", "a", "mk", "vwqe", "fdl", "n", "miyr", "ibh", "den"}));
   }

   private static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
      String finalString = s;
      for (int i = 0; i < sources.length; i++) {
         if (s.indexOf(sources[i], indices[i]) == indices[i]) {
            finalString = finalString.replaceFirst(sources[i], targets[i]);
         }
      }
      return finalString;
   }
}
