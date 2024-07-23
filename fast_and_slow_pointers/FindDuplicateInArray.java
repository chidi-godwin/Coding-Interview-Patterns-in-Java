package fast_and_slow_pointers;

import java.util.Arrays;

public class FindDuplicateInArray {
  public static void main(String[] args) {
    int[][] nums = {
        { 1, 3, 2, 3, 5, 4 },
        { 2, 4, 5, 4, 1, 3 },
        { 1, 6, 3, 5, 1, 2, 7, 4 },
        { 1, 2, 2, 4, 3 },
        { 3, 1, 3, 5, 6, 4, 2 }
    };
    for (int i = 0; i < nums.length; i++) {
      System.out.print(i + 1);
      System.out.println(".\tnums = " + Arrays.toString(nums[i]));
      System.out.println("\tDuplicate number = " + findDuplicate(nums[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }

  public static int findDuplicate(int[] nums) {
    int slow = nums[0], fast = nums[0];

    /**
     * This first loop is used to find the entry point of the loop, here we move the
     * fast pointer in two steps and the slow pointer in one till they meet. This
     * intersection point denotes the entry of the loop
     */
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];

      if (slow == fast) {
        break;
      }
    }

    /**
     * At this point both the fast and the slow pointers are at the intersection
     * point, and we could this point to trace the actual duplicates
     * we move the slow pointer back to starting position, and we keep traversing
     * the array till they both meet again. It is guaranteed that they would meet
     */

    slow = nums[0];

    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    // now both slow and fast are pointing at the duplicate number so we can return
    // any
    return fast;
  }
}
