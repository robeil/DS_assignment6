package CS221Course.src.DS_assignment6;

import java.util.Scanner;
import java.util.Stack;

public class SymbolOperator<E> {
    /**
     * Design a Balanced Symbols Check operator, it should do the following:
     * - Read a mathematical expression from the user
     * - Check and report whether the expression is balanced
     * - {, }, (, ), [, ] are the only symbols considered for the check.
     * All other characters can be ignored.
     *
     */
      public static boolean isBalanced(String expression) {
          Stack<Character> stack = new Stack<>();

          for (int i = 0; i < expression.length(); i++) {
              //reading from the input
              char z = expression.charAt(i);
              //looping to find the opening from the given input
              if (z == '(' || z == '[' || z == '{') {
                  //pushing or adding all the opening bracket into stack
                  stack.push(z);
              }
              //incase the given input does not contains an opening
              if (stack.empty())
                  return false;
              //declaring a character variable to hold the poped emelent
              char hc;
              switch (z) {
                  case ')':
                      //scanned char ia ')' can not be '[' or '{'
                      hc = stack.pop();
                      if (hc == '{' || hc == '[')
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
          return (stack.isEmpty());
      }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your expression HERE please!");
        String userInput = input.nextLine();

        if(isBalanced(userInput)){
            System.out.println("The given expression is balanced");
        } else {
            System.out.println("The given expression is NOT balanced");
        }
    }
}
