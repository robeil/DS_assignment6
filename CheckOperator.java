package CS221Course.src.DS_assignment6;
import java.util.*;
public class CheckOperator {
    /**
     * Design a Balanced Symbols Check operator, it should do the following:
     * - Read a mathematical expression from the user
     * - Check and report whether the expression is balanced
     * - {, }, (, ), [, ] are the only symbols considered for the check.
     * All other characters can be ignored.
     *
     */
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);

        System.out.println("enter your choice ");
        System.out.println("1. to check balanced parenthesis");
        System.out.println("2. convert infix to postfix");
        System.out.println("3. convert postfix to infix");
        System.out.println("4. evaluate postfix");
        System.out.println("5 or any other digit to exit");



        while(true)
        {
            int choice=s.nextInt();
            s.nextLine();
            switch(choice)
            {
                case 1:
                {
                    String input=s.nextLine();
                    if(checkBalanced(input))
                        System.out.println("balanced");
                    else
                        System.out.println("not balanced");
                    break;
                }


                case 2:
                {
                    String input=s.nextLine();
                    if(checkBalanced(input))
                    {
                        String res=infixToPostfix(input);
                        System.out.println(res);
                    }
                    else
                        System.out.println("not balanced");
                    break;
                }

                case 3:
                {
                    String input=s.nextLine();
                    String ans=getInfix(input);
                    System.out.println(ans);
                    break;

                }

                case 4:
                {
                    String input=s.nextLine();
                    int total=evaluatePostfix(input);
                    System.out.println(total);
                    break;
                }

                default:
                    return;
            }

        }
    }



    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '%':
            case '*':
            case '/':
                return 2;


        }
        return -1;
    }


    static String infixToPostfix(String exp)
    {

        String result = new String("");


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);


            if (Character.isLetterOrDigit(c))
                result += c;


            else if (c == '(')
                stack.push(c);


            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }


    static boolean isOperand(char x)
    {
        return (x >= 48 && x <= 57);

    }


    static String getInfix(String exp)
    {
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < exp.length(); i++)
        {

            if (isOperand(exp.charAt(i)))
            {
                s.push(exp.charAt(i) + "");
            }


            else
            {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }


        return s.peek();
    }



    static int evaluatePostfix(String exp)
    {

        Stack<Integer> stack=new Stack<>();


        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);


            if(Character.isDigit(c))
                stack.push(c - '0');


            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;

                    case '%':
                        stack.push(val2%val1);
                }
            }
        }
        return stack.pop();
    }

    public static boolean checkBalanced(String exp) {

        int count=0;
        for(int i=0;i<exp.length();i++)
        {
            if(exp.charAt(i)=='{' || exp.charAt(i)=='(' || exp.charAt(i)=='[' || exp.charAt(i)=='}' || exp.charAt(i)==')' || exp.charAt(i)==']')
                count++;
        }

        if(count%2==1)
            return false;


        Stack<Character> s1=new Stack<Character>();
        for(int i=0;i<exp.length();i++)
        {
            if(exp.charAt(i)=='{' || exp.charAt(i)=='(' || exp.charAt(i)=='[')
            {
// char symbol=exp.charAt(i);
                s1.push(exp.charAt(i));
            }
            else if(exp.charAt(i)=='}')
            {
                char elem=(char)s1.peek();
                if(elem!='{')
                    return false;
                s1.pop();
            }

            else if(exp.charAt(i)==')')
            {
                char elem=(char)s1.peek();
                if(elem!='(')
                    return false;
                s1.pop();
            }

            else if(exp.charAt(i)==']')
            {
                char elem=(char)s1.peek();
                if(elem!='[')
                    return false;
                s1.pop();
            }


        }

        return s1.isEmpty();

    }

}
