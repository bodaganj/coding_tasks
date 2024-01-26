package com.coding.tasks.leetcode.third_round.google.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrobogrammaticNumberII {

  public static void main(String[] args) {
    System.out.println(findStrobogrammatic(2));
    System.out.println(findStrobogrammatic(3));
  }

  public static List<String> findStrobogrammatic(int n) {
    if (n == 0) {
      return Collections.emptyList();
    } else if (n == 1) {
      return List.of("1", "0", "8");
    }

    List<String> ans = new ArrayList<>();
    backtrack("", n, ans);
    return ans;
  }

  private static void backtrack(String current, int n, List<String> ans) {
    if (current.length() == n) {
      ans.add(current);
    } else {
      if (current.length() == n - 2) {
        backtrack("6" + current + "9", n, ans);
        backtrack("9" + current + "6", n, ans);
        backtrack("1" + current + "1", n, ans);
        backtrack("8" + current + "8", n, ans);
      } else if (current.isEmpty() && n % 2 != 0) {
        for (String string : List.of("1", "8", "0")) {
          backtrack(string, n, ans);
        }
      } else {
        backtrack("6" + current + "9", n, ans);
        backtrack("9" + current + "6", n, ans);
        backtrack("1" + current + "1", n, ans);
        backtrack("8" + current + "8", n, ans);
        backtrack("0" + current + "0", n, ans);
      }
    }
  }
}
