package fast_and_slow_pointers;

public class HappyNumber {
  public static void main(String[] args) {
    int a[] = { 1, 5, 19, 25, 7 };
    for (int i = 0; i < a.length; i++) {
      System.out.print((i + 1) + ".\tInput Number: " + a[i]);
      System.out.printf(" isHappyNumber: %s\n", isHappyNumber(a[i])) ;
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }

  }

  public static boolean isHappyNumber(int n) {
    int slow = n;
    int fast = sumOfSquareOfDigits(n);

    while (fast != 1) {
      fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
      slow = sumOfSquareOfDigits(slow);

      if (fast == slow) {
        return false;
      }
    }

    return true;
  }

  public static int sumOfSquareOfDigits(int num) {
    int sum = 0;
    int nextNumber = num;

    while (nextNumber > 0) {
      sum += Math.pow(nextNumber % 10, 2);
      nextNumber = nextNumber / 10;
    }

    return sum;
  }
}
