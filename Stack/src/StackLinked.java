
/**
 * Stack data structure as a Linked List representation.
 * We maintain pointer to the first node of Linked List and
 *  insert/remove from front.
 *
 * Every operation takes constant time in the worst case.
 * Stack with N items uses ~40N bytes
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackLinked<Item> implements Iterable<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node currentFirst = first;
        first = new Node();
        first.item = item;
        first.next = currentFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }




    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            // Not supported
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}