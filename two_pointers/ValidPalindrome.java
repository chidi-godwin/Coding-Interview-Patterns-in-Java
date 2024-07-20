package two_pointers;

public class ValidPalindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome("raceCar"));
    System.out.println(isPalindrome("baab"));
    System.out.println(isPalindrome("abeg"));
  }

  public static boolean isPalindrome(String s) {
    var start = 0;
    var end = s.length() - 1;
    
    while (start < end) {
      if (s.toLowerCase().charAt(start) != s.toLowerCase().charAt(end))
        return false;
      start++;
      end--;
    }

    return true;
  }

}