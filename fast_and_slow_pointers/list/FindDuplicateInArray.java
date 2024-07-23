package fast_and_slow_pointers.list;

public class FindDuplicateInArray {
  public static void main(String[] args) {
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
