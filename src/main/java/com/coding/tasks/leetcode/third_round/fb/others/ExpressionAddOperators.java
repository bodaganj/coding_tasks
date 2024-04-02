package com.coding.tasks.leetcode.third_round.fb.others;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

  public static void main(String[] args) {
    System.out.println(addOperators("123", 6)); // 1+2+3  1*2*3
    System.out.println(addOperators("232", 6)); //
    System.out.println(addOperators("232", 8)); // 2*3+2  2+3*2
    System.out.println(addOperators("237", -1)); // 2*3-7
  }


  public static List<String> addOperators(String num, int target) {
    List<String> ans = new ArrayList<>();
    char c = num.charAt(0);
    rec(c + "", Integer.parseInt(c + ""), num.substring(1), target, ans);
    return ans;
  }

  private static void rec(String current, int curr, String num, int target, List<String> ans) {
    if (num.isEmpty() && curr == target) {
      ans.add(current);
    } else {
      if (!num.isEmpty()) {
        int i = Integer.parseInt(num.charAt(0) + "");
        rec(current + "*" + i, curr * i, num.substring(1), target, ans);
        rec(current + "-" + i, curr - i, num.substring(1), target, ans);
        rec(current + "+" + i, curr + i, num.substring(1), target, ans);
      }
    }
  }
}
