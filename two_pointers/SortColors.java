package two_pointers;

import java.util.Arrays;

public class SortColors {
  private final static int red = 0, blue = 2;
  public static void main(String[] args) {
    int[][] testcases = {
      {0, 1, 0},
      {1, 1, 0, 2},
      {2, 1, 1, 0, 0},
      {2, 2, 2, 0, 1, 0},
      {2, 1, 1, 0, 1, 0, 2}
  };

    for (var test: testcases) {
      sortColors(test);
    }
  }

  public static void sortColors(int[] colors) {
    int start = 0, current = 0;
    int end = colors.length - 1;

    while (current <= end) {
      var color = colors[current];

      if (color == red) {
        while (colors[start] == red && start < current)
          start++;
        swap(current++, start++, colors);
      }
      else if (color == blue) {
        while (colors[end] == blue && end > current)
          end--;
        swap(current, end--, colors);
      }
      else
        current++;
    }

    System.out.println(Arrays.toString(colors));
  }

  public static void swap(int left, int right, int[] arr) {
    var temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
