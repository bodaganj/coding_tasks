package com.coding.tasks.cracking.the.code.recursion_and_dp;

public class ParsingBooleanExpression {

   public static void main(String[] args) {
      System.out.println(parseBoolExpr("!(f)"));
      System.out.println(parseBoolExpr("|(f,t)"));
      System.out.println(parseBoolExpr("&(t,f)"));
      System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));
   }

   /**
    * TO IMPLEMENT!!!
    */
   private static boolean parseBoolExpr(String expression) {
      return true;
   }
}
