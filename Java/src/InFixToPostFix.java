
import java.util.*;

import jdk.nashorn.internal.ir.CallNode.EvalArgs;
public class InFixToPostFix {

	private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }

    private static int getPrecedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }

    // A utility function to check if the given character is operand
    private static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    
	private static String printInfixToPostfix(String infix)
	{
		Stack<Character> operatorStack = new  Stack<Character>();		
		StringBuffer postfix = new StringBuffer(infix.length());
		int len = infix.length();
		for(int i=0;i<len;i++)
		{
			char c = infix.charAt(i);
			if(isOperand(c))
			{
				postfix.append(c);
			}
			else if(c=='(')
			{
				operatorStack.push(c);
			}
			else if(c==')')
			{
				while(!operatorStack.isEmpty()&&operatorStack.peek()!='(')
					postfix.append(operatorStack.pop());
				if(operatorStack.empty()&&operatorStack.peek()!='(')
					return  null;
				else if(!operatorStack.isEmpty())
					operatorStack.pop();
			}
			else if(isOperator(c))
			{
				if(!operatorStack.empty()&&getPrecedence(c)<=getPrecedence(operatorStack.peek()))
					postfix.append(operatorStack.pop());
				operatorStack.push(c);
			}
		}
		
		while(!operatorStack.isEmpty())
			postfix.append(operatorStack.pop());
		
		System.out.println(postfix);
		return postfix.toString();
	}
	
	public static int EvaluatePostFix( String postfix)
	{
		Stack<Integer> result = new Stack<Integer>();
		int len = postfix.length();
		for(int i=0;i<len;i++)
		{
			char c = postfix.charAt(i);
			if(isOperand(c))
				result.push(Character.getNumericValue(c));
			else if(isOperator(c)&&!result.isEmpty())
			{
				int op1 =  result.pop();
				int op2 =  result.pop();
				if(c=='+')
					result.push(op1+op2);
				else if(c=='-')
					result.push(op1-op2);
				else if(c=='*')
					result.push(op1*op2);
				else if(c=='/')
					result.push(op1/op2);
			}
		}
		
		return result.pop();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postfix = printInfixToPostfix("1+2*3+4");
		
		int result =  EvaluatePostFix(postfix);
	}

}
