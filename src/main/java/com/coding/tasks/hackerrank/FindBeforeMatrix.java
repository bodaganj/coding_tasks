package com.coding.tasks.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class FindBeforeMatrix {

   public static void main(String[] args) {
      System.out.println(findBeforeMatrix(List.of(List.of(2, 5), List.of(7, 17))));
   }

   public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
      List<List<Integer>> finalList = new ArrayList<>();

      List<Integer> initialValue = new ArrayList<>();
      initialValue.add(after.get(0).get(0));
      finalList.add(initialValue);

      for (int i = 0; i < after.size(); i++) {
         for (int j = 0; j < after.get(i).size(); j++) {
            if (!(i == 0 && j == 0)) {
               int top = i == 0 ? 0 : after.get(i - 1).get(j);
               int left = j == 0 ? 0 : after.get(i).get(j - 1);
               int topLeft = (i == 0 || j == 0) ? 0 : after.get(i - 1).get(j - 1);
               int newValue = after.get(i).get(j) - left - top + topLeft;

               if (finalList.size() == i) {
                  List<Integer> newList = new ArrayList<>();
                  newList.add(newValue);
                  finalList.add(newList);
               } else {
                  finalList.get(i).add(newValue);
               }
            }
         }
      }

      return finalList;
   }
}
