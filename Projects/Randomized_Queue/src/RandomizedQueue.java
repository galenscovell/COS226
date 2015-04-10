
/**
 * Randomized queue is similar to a stack or queue, except that the item removed 
 * are chosen uniformly at random from items in the data structure.
 *
 * This implementation supports each queue operation in constant amortized time and
 * uses space proportional to the number of items currently in the queue via the use 
 * of a dynamically-sized Array.
 */

import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] contents;
    private int n = 0;

    public RandomizedQueue() {
        contents = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        System.out.println("Items: " + n);
        return contents.length;
    }

    public void print() {
        System.out.print("[");
        for (Item item : contents) {
            System.out.print(item + " ");
        }
        System.out.println("]");
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (n == contents.length) {
            resize(2 * contents.length);
        }
        contents[n++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Random generator = new Random();
        int randomIndex = generator.nextInt(n);
        Item removed = contents[randomIndex];
        if (removed != null) {
            contents[randomIndex] = null;
            n--;
            if (n > 0 && n == contents.length / 4) {
                resize(contents.length / 2);
            }
            return removed;
        } else {
            return dequeue();
        }
            
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Random generator = new Random();
        int randomIndex = generator.nextInt(n);
        return contents[randomIndex];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        Item[] nonNull = (Item[]) new Object[n];
        int pos = 0;
        for (Item item : contents) {
            if (item != null) {
                nonNull[pos] = item;
                pos++;
            }
        }

        for (int i = 0; i < n; i++) {
            copy[i] = nonNull[i];
        }
        contents = copy;
    }




    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int i = n;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return contents[--i];
        }
    }
}