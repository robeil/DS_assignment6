package CS221Course.src.DS_assignment6;
import java.util.*;

public class balancedCheck {

        // Method to check if the expression has balanced brackets
        static boolean Balanced(String exp)
        {
        //Creating a Dequeue with character class
            Deque<Character> stack = new ArrayDeque<Character>();
        // Scanning the expression
            for (int i = 0; i < exp.length(); i++)
            {
                char z = exp.charAt(i);//Reading a character from expression
                if (z == '(' || z == '[' || z == '{')
                {
        // Pushing all the opening brackets of expression into stack
                    stack.push(z);
                }
         // In case the current scanned character is not an opening bracket then it could be a closing bracket or any other literal.
        //Therefore, in either case, stack can't be empty
                if (stack.isEmpty())
                    return false;
        //Pop out the last element from the stack, to check if it matches with current scanned close bracket.
                char hc; //Declaring a character variable to hold the popped elements of stack
                switch (z) {
                    case ')':
        //Scanned character is ')'. So, popped out element can't be '{' or '['
                        hc = stack.pop();
                        if (hc== '{' || hc == '[')
                            return false;
                        break;
                    case '}':
                        hc = stack.pop();
                        if (hc == '(' || hc == '[')
                            return false;
                        break;
                    case ']':
                        hc = stack.pop();
                        if (hc == '(' || hc == '{')
                            return false;
                        break;
                }
            }
        // Checking if the stack is empty
            return (stack.isEmpty());
        }
        public static void main(String[] args)
        {
        //Creating an object with Scanner class
            Scanner j = new Scanner(System.in);
        //Reading the expression
            System.out.println("Enter the expression :");
            //Declaring a string for reading the string from user
            String exp = j.nextLine();
        // Calling the respective method for balance check
            if (Balanced(exp))
                System.out.println("Expression is balanced ");
            else
                System.out.println("Expression is not balanced ");
        }
    }


