import java.util.Stack;

public class HighRadiusExpressionProblem {

	//Problem

	//Write a Pseudo code to parse a String and and evaluate expressions like:

	//(+ 5 4 6)

	//(* 2 (- 7 3) 4)

	//(+ 3 (* 5 2) (- 6 3))
	
	//return the evaluted value and we can add more operation easily
	public static int performOperation(int operand1, int operand2, Character operator)
	{
		if(operator=='+')
			return operand1+operand2;
		else if(operator=='-')
			return operand1-operand2;
		else if(operator=='*')
			return operand1*operand2;
		else if(operator=='/')
			return operand1/operand2;
		else return 0;
	}
	
	private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
	
	//Stack will keep the result
	//Using recursion to solve the problem in sub part
	public static int EvaluatePreFixTypeExpression(String prefix /*(+546)*/)
	{
		Stack<Integer> result = new Stack<Integer>();
		if(prefix.length()<startIndex)
			return -1;
		char c = prefix.charAt(startIndex);
		
		if(c=='(')
		{
			startIndex=startIndex+1;
			char operator = prefix.charAt(startIndex);
			startIndex=startIndex+1;
			c = prefix.charAt(startIndex);
			while(c!=')'&&!isOperator(c))
			{
				if(c=='(')
				{
					int temp = EvaluatePreFixTypeExpression(prefix);
					if(temp!=Integer.MIN_VALUE)
						result.push(temp);
					else
						return result.pop();
				}
				else 
				{
					result.push(Character.getNumericValue(c));		
				}
				
				while(result.size()>1)
				{
					int op1 =  result.pop();
					int op2 =  result.pop();
					result.push(performOperation(op2, op1, operator));
				}
				startIndex=startIndex+1;
				c = prefix.charAt(startIndex);
			}
			
		}
		if(!isOperator(c))
			return result.pop();
		System.out.println("Invalid Expression");
		return Integer.MIN_VALUE;

	}
	static int startIndex = 0;
	public static void main(String[] args) {
		int result = EvaluatePreFixTypeExpression("(*2(-73)4)");
		if(result!=Integer.MIN_VALUE)
			System.out.println("Output = " + result);
	}
}
