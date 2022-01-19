package CS221Course.src.DS_assignment6;

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
      public static boolean Balanced(String exp){
          Stack<Character> stack = new Stack<>();

          for(int i = 0; i < exp.length(); i++){
              //reading from the input
              char z = exp.charAt(i);
              //looping to find the opening from the given input
              if(z == '(' || z == '[' || z == '{'){
                  //pushing or adding all the opening bracket into stack
                  stack.push(z);
              }
          }
        }


}
