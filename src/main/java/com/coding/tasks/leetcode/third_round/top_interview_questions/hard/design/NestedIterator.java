package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

   private final Stack<List<NestedInteger>> listStack;
   private final Stack<Integer> indexStack;

   public NestedIterator(List<NestedInteger> nestedList) {
      listStack = new Stack<>();
      indexStack = new Stack<>();
      listStack.add(nestedList);
      indexStack.add(0);
   }

   @Override
   public Integer next() {
      if (hasNext()) {
         Integer currIndex = this.indexStack.pop();
         indexStack.add(currIndex + 1);
         return listStack.peek().get(currIndex).getInteger();
      } else {
         return null;
      }
   }

   @Override
   public boolean hasNext() {
      while (!indexStack.isEmpty()) {
         if (indexStack.peek() == listStack.peek().size()) {
            indexStack.pop();
            listStack.pop();
         } else {
            if (listStack.peek().get(indexStack.peek()).isInteger()) {
               return true;
            } else {
               int currentIndex = indexStack.pop();
               indexStack.add(currentIndex + 1);
               listStack.add(listStack.peek().get(currentIndex).getList());
               indexStack.add(0);
            }
         }
      }
      return !listStack.isEmpty();
   }

   // This is the interface that allows for creating nested lists.
   // You should not implement it, or speculate about its implementation
   public interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
   }
}
