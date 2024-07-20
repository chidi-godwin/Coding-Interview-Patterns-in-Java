package two_pointers;

import java.util.Arrays;

public class ThreeSum {
  public static void main(String[] args) {
    // Test case 1
    int[] nums1 = {1, -1, 0};
    int target1 = 2;
    System.out.println("Test Case 1: " + findSumOfThree(nums1, target1));

    // Test case 2
    int[] nums2 = {1, 2, 3, 4, 5};
    int target2 = 9;
    System.out.println("Test Case 2: " + findSumOfThree(nums2, target2));

    // Test case 3
    int[] nums3 = {-1, 0, 1, 2, -1, -4};
    int target3 = 0;
    System.out.println("Test Case 3: " + findSumOfThree(nums3, target3));

    // Test case 4
    int[] nums4 = {2, 3, 4, 5, 6};
    int target4 = 12;
    System.out.println("Test Case 4: " + findSumOfThree(nums4, target4));
  }

  public static boolean findSumOfThree(int[] nums, int target) {
    Arrays.sort(nums);

    var size = nums.length;

    for (var i = 0; i < size - 2; i++) {
      var localTarget = target - nums[i];

      var start = i + 1;
      var end = size - 1;

      while (start < end) {
        int left = nums[start], right = nums[end];
        var localSum = left + right;

        if (localSum == localTarget)
          return true;
        else if (localSum < localTarget )
          start++;
        else
          end--;
      }
    }
    return false;
  }
}