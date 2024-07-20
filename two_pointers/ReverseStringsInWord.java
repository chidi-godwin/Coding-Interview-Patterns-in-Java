package two_pointers;

import java.util.ArrayList;

public class ReverseStringsInWord {
  public static void main(String[] args) {
    var sentence = new StringBuilder("e");
    sentence.reverse();
    System.out.printf("Reversed String: %s\n", sentence.toString());
    System.out.println(reverseWordsInSentence(sentence.toString()));
  }

  public static String reverseWordsInSentence(String sentence) {
    int start = 0, end = sentence.length() - 1;
    var reversedWords = new ArrayList<String>();

    while (start < end) {
      var wordIndexes = findNextWord(start, end, sentence);
      int leftIndex = wordIndexes[0], rightIndex = wordIndexes[1];

      if (leftIndex < rightIndex) {
        reversedWords.add(reverseWord(sentence.substring(leftIndex, rightIndex)));
      }

      start = ++rightIndex;
    }

    return String.join(" ", reversedWords);
  }

  public static String reverseWord(String word) {
    var sb = new StringBuilder(word);

    return sb.reverse().toString();
  }

  public static int[] findNextWord(int start, int end, String sentence) {
    int left = start;

    while (left < end && sentence.charAt(left) == ' ')
      left += 1;

    int right = left;

    while (right < end && sentence.charAt(right) != ' ')
      right += 1;

    int[] indexes = { left, right };
    return indexes;
  }

}
