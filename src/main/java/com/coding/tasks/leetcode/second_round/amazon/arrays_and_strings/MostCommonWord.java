package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

   public static void main(String[] args) {
      System.out.println(mostCommonWord("Bob", new String[]{"hit"}));
      System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
      System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
      System.out.println(mostCommonWord(
         "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'",
         new String[]{"m", "i", "s", "w", "y", "d", "q", "l", "a", "p", "n", "t", "u", "b", "o", "e", "f", "g", "c", "x"}));
   }

   private static String mostCommonWord(String paragraph, String[] banned) {
      Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

      int maxCount = -1;
      String maxStr = "";
      Map<String, Integer> map = new HashMap<>();
      StringBuilder sb = new StringBuilder();

      for (char aChar : paragraph.toCharArray()) {
         if (Character.isLetter(aChar)) {
            sb.append(aChar);
         } else {
            if (sb.length() > 0) {
               String word = sb.toString().toLowerCase();
               map.put(word, map.getOrDefault(word, 0) + 1);
               if (maxCount < map.get(word) && !bannedSet.contains(word)) {
                  maxCount = map.get(word);
                  maxStr = word;
               }
               sb = new StringBuilder();
            }
         }
      }
      if (sb.length() > 0) {
         String word = sb.toString().toLowerCase();
         map.put(word, map.getOrDefault(word, 0) + 1);
         if (maxCount < map.get(word) && !bannedSet.contains(word)) {
            maxStr = word;
         }
      }

      return maxStr;
   }
}
