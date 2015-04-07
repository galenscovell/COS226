
/**
 * Implementations of the Stack data structure.
 *
 * Linked List: Has constant time in the worst case, guaranteed. Can utilize Generics easily.
 * Takes more memory to operate.
 *
 * Array: Has constant amortized time (doubling and halving takes N time).
 * Takes less memory to operate. Requires type-casting for Generics.
 */

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        StackLinked<String> stack = new StackLinked<String>();
        Scanner reader = new Scanner(System.in);

        String input = "";
        System.out.println("\n'item': push item to stack\n'-': pop from stack\n'end': quit\n");
            

        while (!input.equals("end")) {
            System.out.print(" > ");
            input = reader.nextLine();

            if (input.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(input);
            }
        }
        System.out.println("Ending application.\n");
    }
}