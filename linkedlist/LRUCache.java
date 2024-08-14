package linkedlist;

import java.util.HashMap;

class Node {
  private final int key;
  private final int value;
  private Node next, prev;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;

  }

  public int getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public void setNext(Node node) {
    this.next = node;
  }

  public Node getNext() {
    return this.next;
  }

  public void setPrev(Node node) {
    this.prev = node;
  }

  public Node getPrev() {
    return this.prev;
  }
}

public class LRUCache {
  private final int capacity;
  private final HashMap<Integer, Node> cache = new HashMap<>();
  private final Node head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node(0, 0);
    tail = new Node(0, 0);

    // connect the nodes together
    head.setNext(tail);
    tail.setPrev(head);
  }

  private void insert(Node node) {
    // insert at the tail of the list
    // the dummy tail value must not be removed
    // so we are basically inserting at the node before the tail
    Node prev = tail.getPrev();
  
    prev.setNext(node); tail.setPrev(node);
    node.setNext(tail); node.setPrev(prev);
  }

  private void remove(Node node) {
    node.getPrev().setNext(node.getNext());
    node.getNext().setPrev(node.getPrev());
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      remove(node);
      insert(node);
      return node.getValue();
    }

    return -1;
  }

  public void put(int key, int value) { 
    // the node is already in the cache, then remove it form the list cause it woudl be reinserted at the most recent used place
    if (cache.containsKey(key))
      remove(cache.get(key));

    // create new node for insertion
    Node node = new Node(key, value);
    cache.put(key, node);

    // insert node to the most recent used
    insert(node);

    if (cache.size() > capacity) {
      // get and remove less recently used
      Node LRU = head.getNext();
      remove(LRU);
      cache.remove(LRU.getKey());
    }     
  }
}
