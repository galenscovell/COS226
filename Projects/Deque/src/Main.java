
/**
 * Project #2 of COS226, creation of Deque and Randomized Queue data structures.
 */

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        System.out.println("Add 1 to front, 2 to front, 3 to end, 4 to end.");
        deque.addFirst(1);
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");
        deque.addFirst(2);
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");
        deque.addLast(3);
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");
        deque.addLast(4);
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");

        Iterator<Integer> iter = deque.iterator();
        System.out.println("Iterator at: " + iter.next());
        System.out.println("Iterator at: " + iter.next());
        System.out.println("Iterator at: " + iter.next());
        System.out.println("Iterator at: " + iter.next());
        
        System.out.println("\nRemove first item.");
        System.out.println("Item was " + deque.removeFirst());
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");

        System.out.println("\nRemove last item.");
        System.out.println("Item was " + deque.removeLast());
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");

        System.out.println("\nRemove first item.");
        System.out.println("Item was " + deque.removeFirst());
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");

        System.out.println("\nRemove last item.");
        System.out.println("Item was " + deque.removeLast());
        System.out.print("Deque contents: ");
        deque.print();
        System.out.println(" [" + deque.size() + "]");
    }
}