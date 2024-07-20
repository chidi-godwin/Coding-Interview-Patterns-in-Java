package two_pointers;

public class ValidPalindrom2 {

  public static void main(String[] args) {
    var wordArray = new String[] {
        "madame",
        "dead",
        "abca",
        "tebbem",
        "eeccccbebaeeabebccceea"
    };

    System.out.println();

    for (var word: wordArray) {
      System.out.printf("%s is valid palindrome before or after omission: %s\n", word, validPalindrome(word));
    }
  }

  public static boolean validPalindrome(String word) {
    int start = 0, end = word.length() - 1;

    while (start < end) {
      if (word.charAt(start) != word.charAt(end)) {
        return isSubStringPalindrome(word, start, end - 1) || isSubStringPalindrome(word, start + 1, end);
      }

      start++; end--;
    }

    return true;
  }

  public static boolean isSubStringPalindrome(String subString, int start, int end) {
    while (start < end) {
      if (subString.charAt(start) != subString.charAt(end))
        return false;

      start++;
      end--;
    }

    return true;
  }
}
