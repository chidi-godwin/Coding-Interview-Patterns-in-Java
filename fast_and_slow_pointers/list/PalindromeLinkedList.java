package fast_and_slow_pointers.list;

import fast_and_slow_pointers.list.structures.LinkedList;
import fast_and_slow_pointers.list.structures.LinkedListNode;
import fast_and_slow_pointers.list.structures.PrintList;

public class PalindromeLinkedList {
  
  public static void main(String[] args) {
    int[][] input={
          {2, 4, 6, 4, 2},
          {0, 3, 5, 5, 0},
          {9, 27, 4, 4, 27, 9},
          {5, 4, 7, 9, 4, 5},
          {5, 10, 15, 20, 15, 10, 5}
          };
        
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = isPalindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
  }
  
  public static boolean isPalindrome(LinkedListNode head) {
    LinkedListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    LinkedListNode middle = reverseList(slow), start = head;

    return compare(middle, start);
  }

  public static LinkedListNode reverseList(LinkedListNode head) {
    LinkedListNode previous = null, current = head, next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public static boolean compare(LinkedListNode first, LinkedListNode second) {
    while (first != null && second != null) {
      if (first.data != second.data) {
        return false;
      }

      first = first.next;
      second = second.next;
    }

    return true;
  }
}
