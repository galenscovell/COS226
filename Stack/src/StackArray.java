
/**
 * Stack data structure as an Array.
 *
 * Compared to Linked List, Array is faster but has limited capacity.
 * To combat this problem, implement repeated-doubling of the Array:
 * When Array capacity is reached, create new Array with double capacity.
 * When Array is 1/4 full, halve size of Array.
 *
 * Doubling and halving takes N time, but occurs rarely. Otherwise constant time.
 * Memory usage is between ~8N and ~32N
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackArray<Item> implements Iterable<Item> {
    private Item[] contents;
    private int n = 0;

    public StackArray() {
        contents = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        // Array doubling
        if (n == contents.length) {
            resize(2 * contents.length);
        }
        contents[n++] = item;
    }

    public Item pop() {
        Item item = contents[--n];
        contents[n] = null;
        // Array halving
        if (n > 0 && n == contents.length / 4) {
            resize(contents.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = contents[i];
        }
        contents = copy;
    }



    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = n;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            // Not supported
        }

        public Item next() {
            return contents[--i];
        }
    }
}