package eg.edu.alexu.csd.datastructure.stack.cs29;

public class EvaluatorMF implements IExpressionEvaluator {
	private IStack stack1 = new MyStack();
	/**
	 * This method is to check if the input has valid brackets
	 * which means it test if each opened brackets is to be closed or not
	 * 
	 * 
	 * @param s is the input string which to be evaluated
	 * 
	 * 
	 * @return a boolean expression of true or false if the brackets are appropriate or not
	 */
	private boolean checkBrac(String s) {
		int size = s.length();
		IStack stack = new MyStack();
		for (int i=0; i<size ; i++) {
			if (s.charAt(i) == '(')
				stack.push(s.charAt(i));
			else if (s.charAt(i) == ')')
				stack.pop();
		}
		if (stack.isEmpty())
			return true;
		else return false;
	}
	/**
	 * Checks the type of a specific character in the input string if it is a number,
	 * bracket,operand or none of them
	 * 
	 * 
	 * @param c the character to be evaluated
	 * 
	 * 
	 * @return a short integer representing the genre of the character
	 *         1 for operation
	 *         2 for digits
	 *         3 for brackets
	 *         0 for anything else which is invalid 
	 */
	private short type (char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' ) {
			return 1;
		}
		else if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' ) {
		 return 2;	
		}
		else if (c== ')' || c=='(') {
			return 3;
		}
		else return 0;
	}
	/**
	 * This method indicates the priority of each operation by giving it a value
	 * 
	 * 
	 * @param c the character representing the operation
	 * 
	 *  
	 * @return a short integer 
	 *         1 for * and /
	 *         2 for + and -
	 *         0 for brackets
	 */
	private short weigh(char c) {
		if (c == '*' || c == '/' ) 
			return 2;
		else if (c=='(') {
			return 0;
		}
		else return 1;
	}
	/**
	 * This method set the values of the stack that will be used in the conversion from infix 
	 * to postfix, by adding values to the string and after all digits entering the operation 
	 * are written in the string the stack pops the right operation sign in the string
	 * 
	 * 
	 * @param c is the character of the input string that will be checked for its type
	 *          and if it is an operation its weight
	 *          
	 *          
	 * @param s is the string representing the postfix notation of the input which is being formed 
	 *          by this method
	 *          
	 *          
	 * @return a string which is postfix representation of the input
	 */
	private String setStack(char c,String s) {
		 if (stack1.isEmpty()) {
			  stack1.push(c);
			  return s;
		  }
		  else {
		  short w = weigh(c);
		  short ws = weigh((char)stack1.peek());
		  if (w > ws) {
			  stack1.push(c);
			  return s;
		  }
		  else if ((char)stack1.peek() != '('){
			  s = s + stack1.pop() +" ";
			  setStack(c,s);
		  }
	    }
		 return s;
	}
	/**
	 * This method uses all the previous methods to convert from infix to postfix notation
	 * 
	 *   
	 * @param expression is the string in the infix notation
	 * 
	 * @return a string that is the postfix notation of the input
	 */
	public String infixToPostfix(String expression){
		String s = "";
		if (!checkBrac(expression)) {
			System.out.println("Wrong Bracket input");
			return null;
		}
		int size = expression.length();
		for (int i=0; i<size ; i++) {
			  short k = type(expression.charAt(i));
			  if (k == 2) {

				  s = s+expression.charAt(i);
			  }
			  else if (k == 1) {
				  s=s+" ";
				 s= setStack(expression.charAt(i),s);
			  }
			  else if (k==3) {
				 if (expression.charAt(i) == '(') {
					 stack1.push(expression.charAt(i));
				 }
				 else {
					 s = s +" ";
					 while ((char)stack1.peek() != '(') {
						 s=s+stack1.pop() +" ";
					 }
					 stack1.pop();
				 }
			  }
		  }
		while (!stack1.isEmpty()) {
			  s=s+" "+stack1.pop();
		  }
		return s;
	}
	/**
	 * This method calculates a certain expression in postfix notation by using the stacks
	 * 
	 * 
	 * @param expression is the expression to be calculated
	 * 
	 * 
	 * @return an integer which the value of the input expression
	 */
	public int evaluate(String expression) {
		String[] S = expression.split(" ");
		int size = S.length;
		int value = 0;
		for (int i=0 ; i<size ; i++) {
			String h="";
			for(int j=0 ; j<S[i].length(); j++) {
				if(S[i].charAt(j) != ' ') {
					h=h+S[i].charAt(j);
				}
			}
			S[i] = h;
		}
		for (int i=0; i<size ; i++) {
			if (S[i] == " " || S[i] == "") {}
			else {
				char c = S[i].charAt(0);
				if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {
					int k = (int)stack1.pop();
					int l = (int)stack1.pop();
					switch (c) {
					case '+':
						stack1.push(k+l);
					break;
					case '-':
						stack1.push(l-k);
					break;
					case '*':
						stack1.push(k*l);
					break;
					case '/':{
						int p = (int)Math.round(l*1.0/k*1.0);
						stack1.push(p);
				}
					}
					
				}
				else {
					int j = Integer.parseInt(S[i]);
					stack1.push(j);
				}
			}
		}
		value = (int)stack1.pop();
		return value;
		
}
}