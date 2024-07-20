package two_pointers;

class Node {
  public int data;
  public Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList<T> {
  public Node head;

  public LinkedList() {
    this.head = null;
  }

  public void insertNodeAtHead(Node node) {
    if (this.head == null) {
      this.head = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
  }

  public void createLinkedList(int[] lst) {
    for (int i = lst.length - 1; i >= 0; i--) {
      Node newNode = new Node(lst[i]);
      insertNodeAtHead(newNode);
    }
  }

}

public class NthNodeFromList {
  public static void main (String[] args) {}

  public Node removeNthNodeFromTail(Node head, int n) {
  
    Node prev = head, nth = head;

    for (int i = 0; i< n; i++)
      nth = nth.next;

    // edge case: if the nth node is the head, then nth would be pointing to null now
    if (nth == null)
      return head.next;
    
    while (nth.next != null) {
      prev = prev.next;
      nth = nth.next;
    }

    prev.next = prev.next.next;

    return head;
  }
}
