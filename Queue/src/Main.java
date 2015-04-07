
/**
 * Implementation of Queue data structure.
 */

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        QueueLinked queue = new QueueLinked();
        Scanner reader = new Scanner(System.in);

        String input = "";
        System.out.println("\n'item': enqueue item\n'-': dequeue item\n'print': print queue contents\n'end': quit\n");
            

        while (!input.equals("end")) {
            System.out.print(" > ");
            input = reader.nextLine();

            if (input.equals("print")) {
                queue.printQueue();
            } else if (input.equals("-")) {
                System.out.println(queue.dequeue());
            } else {
                queue.enqueue(input);
            }
        }
        System.out.println("Ending application.\n");
    }
}