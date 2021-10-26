package com.coding.tasks.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QualtricsGetSortedPermutationTask {

   public static void main(String[] args) {
      System.out.println(findString("abc"));
      System.out.println(findString("cab"));
      System.out.println(findString("ccc"));
   }

   /**
    * Find the final string which is the last (in terms of sorting) combination of letters (you are not able to change positions)
    * E.g.
    * abc -> a, b, c, ab, ac, bc, abc -> c
    * cab -> c, a, b, ca, cb, ab, cab -> cb
    * ccc -> c, cc, ccc ->               ccc
    */
   public static String findString(String input) {
      List<String> inputList = new ArrayList<>(Arrays.asList(input.split("")));
      return runRecursion("", inputList);
   }

   private static String runRecursion(String result, List<String> inputList) {
      if (inputList.size() == 0) {
         return result;
      } else {
         int indexOfTheBiggestLetter = getIndexOfBiggestLetter(inputList);
         return runRecursion(result + inputList.get(indexOfTheBiggestLetter),
                             inputList.subList(indexOfTheBiggestLetter + 1, inputList.size()));
      }
   }

   private static int getIndexOfBiggestLetter(List<String> list) {
      List<String> sortedInputList = list.stream().sorted().collect(Collectors.toList());
      String lastString = sortedInputList.get(sortedInputList.size() - 1);
      return list.indexOf(lastString);
   }
}
