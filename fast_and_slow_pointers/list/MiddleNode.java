package fast_and_slow_pointers.list;

import fast_and_slow_pointers.list.structures.LinkedList;
import fast_and_slow_pointers.list.structures.LinkedListNode;
import fast_and_slow_pointers.list.structures.PrintList;

public class MiddleNode {
  public static void main(String[] args) {
    int[][] input = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5, 6 }, { 3, 2, 1 }, { 10 }, { 1, 2 } };

    for (int i = 0; i < input.length; i++) {
      System.out.print(i + 1);
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.createLinkedList(input[i]);
      System.out.print(".\tInput linked list:  ");
      PrintList.printListWithForwardArrow(list.head);
      System.out.print("\tMiddle of the linked list is:  ");
      System.out.println(middleNode(list.head).data);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }

  public static LinkedListNode middleNode(LinkedListNode head) {
    LinkedListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;

  }
}
