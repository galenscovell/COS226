
/**
 * Project #2 of COS226, creation of Deque and Randomized Queue data structures.
 */

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        
        if (args.length == 0) {
            System.out.println("Must provide integer arguments for queue.");
            System.exit(0);
        } else {
            for (String arg : args) {
                int converted = Integer.parseInt(arg);
                queue.enqueue(converted);
            }
        }
        
        System.out.print("Contents: ");
        queue.print();
        System.out.println("Size: " + queue.size());

        System.out.println("\nDequeue " + queue.dequeue());
        System.out.print("Contents: ");
        queue.print();
        System.out.println("Size: " + queue.size());

        System.out.println("\nDequeue " + queue.dequeue());
        System.out.print("Contents: ");
        queue.print();
        System.out.println("Size: " + queue.size());

        System.out.println("\nDequeue " + queue.dequeue());
        System.out.print("Contents: ");
        queue.print();
        System.out.println("Size: " + queue.size());

        System.out.println("\nDequeue " + queue.dequeue());
        System.out.print("Contents: ");
        queue.print();
        System.out.println("Size: " + queue.size());
    }
}