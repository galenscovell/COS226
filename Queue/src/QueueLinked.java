
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
        // Save link to last node
        Node oldLast = last;
        // Create new node for end
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            // If queue empty, add to front
            first = last;
        } else {
            // Link new node to end of list
            oldLast.next = last;
        }
    }

    public String dequeue() {
        // Save item to return
        String item = first.item;
        // Delete first node
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        // Return saved item
        return item;
    }

    public void printQueue() {
        while (!isEmpty()) {
            System.out.println(first);
            first = first.next;
        }
    }
}