
/**
 * Queue as a Linked List.
 *
 * Maintains pointer to both first and last nodes in Linked List, insert/remove from opposite ends.
 *
 */


public class QueueLinked {
    private Node first, last;

    private class Node {
        String item;
        Node next;

        public String toString() {
            return item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public void printQueue() {
        while (!isEmpty()) {
            System.out.println(first);
            first = first.next;
        }
    }
}