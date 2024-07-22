package fast_and_slow_pointers.list;

public class CircularArray {
  public static void main(String[] args) {}

  public static boolean circularArrayLoop(int[] nums) {
    int size = nums.length;

    // iterate through the array of numbers and chekc if you can find a cycle at any of it's indexes
    for (int i = 0; i < size; i++) {
      int slow = i, fast = i;

      boolean forward = nums[slow] > 0; // tracks the direction, false for backward

      while (true) {
        slow = nextStep(slow, nums[slow], size);

        // check if a cylce can be found from the index pointed to by slow
        if (!canLeadToCycle(nums, forward, slow))
          break;

        fast = nextStep(fast, nums[fast], size);

        if (!canLeadToCycle(nums, forward, fast))
          break;

        fast = nextStep(fast, nums[fast], size);

        if (!canLeadToCycle(nums, forward, fast))
          break;

        if (slow == fast)
          return true;
      }
    }

    return false;
  }
 
  public static int nextStep(int pointer, int value, int size) {
    int nextPoint = (pointer + value) % size;
    if (nextPoint < 0)
      nextPoint += size;
    
    return nextPoint;
  }

  // this function confirms the possibility of a cycle being found from the pionter
  public static boolean canLeadToCycle(int[] nums, boolean previousDirection, int pointer) {
    // here the pointer refers to a new pointer after a previous movement
    // prev direction tells you if the step taken before this was in the forward or backward direction
    boolean currentDirection = nums[pointer] > 0;

    // if the directions aren't the same then the directions have changed which then it's not possible it leads to a cyle
    // also if the value at the pointer, leads the pointer to the same index to which it's pointing to, that's a self loop, so we should move
    // we could determine if the value would need to the same index, using this caluculation (value % arrLength == 0)
    // this works because at any index in the array, if you take the array length number of steps from that index in a circular manner you would land back at the same index
    // let's say for an array of length 4, at index two, if you take 4 steps in a cirular fashion you would land back at index two 
    // proof ((2 + 4) % 4) == 2;
    // so if the value pointed to is a perfect multiple of the length of the array size, then it leads back to the same index everytime
    if (previousDirection != currentDirection || Math.abs(nums[pointer] % nums.length) == 0)
      return false;
   
    return true;
  }
}
