
/**
 * A double-ended queue (deque) is a generalization of a stack and a queue 
 * that supports inserting and removing items from either the front or the back 
 * of the data structure.
 *
 * This implementation supports each deque operation in constant worst-case time and
 * uses space proportional to the number of items currently in the deque via the use 
 * of Linked Lists.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;


public class Deque<Item> implements Iterable<Item> {
    private Node first, last;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;

        if (oldFirst != null) {
            first.next = oldFirst;
            last = oldFirst;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else if (oldLast == null) {
            first.next = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldFirst = first;
        first = first.next;
        return oldFirst.item;
    }

    public Item removeLast() {
        if (first.next == null) {
            return removeFirst();
        } else {
            Node currentFirst = first;
            Node oldLast = last;
            while (first.next != oldLast) {
                first = first.next;
            }
            first.next = null;
            first = currentFirst;
            return oldLast.item;
        }
    }



    public int size() {
        int size = 0;
        Node oldFirst = first;
        while (!isEmpty()) {
            first = first.next;
            size++;
        }
        first = oldFirst;
        return size;
    }

    public void print() {
        Node oldFirst = first;
        while (!isEmpty()) {
            System.out.print(first.item + " ");
            first = first.next;
        }
        first = oldFirst;
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
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item item = current.item;
            if (hasNext()) {
                current = current.next;
                return item;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}