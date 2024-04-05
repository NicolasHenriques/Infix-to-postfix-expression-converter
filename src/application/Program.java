		//Code made by:
// - Marco Antonio de Camargo      | RA: 10418309
// - Natan Moreira Passos          | RA: 10417916
// - Nicolas Henriques de Almeida  | RA: 10418357
//References:
// - https://profkishimoto.github.io/edi03d-2024-1/atividades/n1/EDI-2024.1%20-%20Apl1.pdf
// - https://www.calcont.in/Calculator/Postfix_calculator/
// - https://www.ascii-code.com
// - https://www.baeldung.com/java-check-string-contains-only-letters-numbers
// - https://www.w3docs.com/snippets/java/any-shortcut-to-initialize-all-array-elements-to-zero.html#:~:text=If%20you%20want%20to%20create,fill%20method.&text=This%20will%20create%20a%20new,of%20the%20array%20to%20zero.
// - https://www.javatpoint.com/how-to-return-an-array-in-java
// - https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/

package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.CharStack;
import util.FloatStack;

public class Program {
	//Method that receives no parameter and has
	//no return. Only used to show the menu
	//to the user
	public static void showMenu() {
		System.out.println("""
				===================== Menu =====================
				1. Write the desired infix arithmetic expression
				2. Enter the numeric values for each variable
				3. Conversion from infix to postfix expression
				4. Evaluate the expression
				5. Exit
				""");
	}
	
	//Method that receives a char and checks
	//if it is an upper case letter.
	//Returns true if it is, returns false if it isn't
	public static boolean isLetter(char check) { //check if the character is a letter
		return (check >= 65 && check <= 90);
	}
	
	//Method that receives a char and checks
	//if it is an arithmetic operator.
	//Returns true if it is, returns false if it isn't
	public static boolean isOperator(char check) { //check if the character is an operand
		return check=='+'||check=='-'||check=='*'||check=='/'||check=='^';
	}
	
	//Method that receives a char as a parameter
	//and checks it's priority.
	//Returns the corresponding priority as an int
	public static int priorityCheck(char check) { //see the "priority level" of the character
		switch (check) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
			    return 3;
			default:
			    return 0;
		}
	}
	
	//Method that receives a String containing an infix expresssion
	//and an integer array to store which variables were used.
	//Returns true if the expression has variables and false if not.
	public static boolean checkVariables(String infixExpression, int variables[]) {
		boolean hasVariables = false;
		for(int i=0;i<infixExpression.length();i++) 
			if(isLetter(infixExpression.charAt(i))) {
				variables[infixExpression.charAt(i) - 65] = 1;
				hasVariables = true;
			}
		
		return hasVariables;
	}
	
	//Method that receives a scanner object, a String containing the
	//infix expression and an integer array to store the variables' values 
	//as parameters. This method doesn't return anything
	public static void readVariablesValues(Scanner sc, String infixExpression, int values[]) {
		//creating an array to store what variables were used
		int variables[] = new int[26];
		Arrays.fill(variables, 0);
		
		boolean hasVariables = false;
		hasVariables = checkVariables(infixExpression, variables);
		
		if(hasVariables) {
			for(int i=0;i<26;i++) {
				if(variables[i] != 0) {
					System.out.print("Enter the value for " + (char)(i+65) + ": ");
					//[TODO] handle type mismatch exception
					values[i] = sc.nextInt();
				}
			}
		}
		else {
			System.out.println("Your expression has no variables!");
		}
	}
	
	//Method that receives an String containing an
	//infix expression, converts it to a postfix expression
	//and returns it in a String
	public static String convertInfixToPostfix(String ie) {
		//creating stack object
		CharStack postfixExpression = new CharStack();
	
		//creating String variable that will be returned
		String postfix = "";
		//creating variable to store the priority of an operand
		int previousPriority = 0;
	
		for(int i=0;i<ie.length();i++) {
			if(isLetter(ie.charAt(i))){
				postfix += ie.charAt(i);
			}
			else if(isOperator(ie.charAt(i))) {
				previousPriority = priorityCheck(postfixExpression.top()); //if an operand is found. Check if its priority is less/equal than the previous
				if(previousPriority >= priorityCheck(ie.charAt(i))){ //if it is, pop the last one from the stack and push the new one. If it isn't, just add the new one to the stack
					postfix += postfixExpression.pop();
				}
				postfixExpression.push(ie.charAt(i));
			}
			else if(ie.charAt(i) == '(') { //add ( to the stack
				postfixExpression.push(ie.charAt(i));
			}
			else if(ie.charAt(i) == ')') { //if an ) is found, pop everything until you find a (
				while(!postfixExpression.isEmpty() && postfixExpression.top() != '(') {
					postfix += postfixExpression.pop();
				}
				postfixExpression.pop(); 
			}
		}
		while(!postfixExpression.isEmpty()) { //pop the remaining elements of the stack
			postfix += postfixExpression.pop();
		}
		return postfix;
	}
	
	//Method that receives a scanner object as a parameter,
	//reads user input for the desired expression and 
	//returns the infix arithmetic expression as a String
	public static String writeExpression(Scanner sc) {
		sc.nextLine();
		String exp = "";
		while(true) {
			System.out.println("Type the expression (use only letters and operators. No spaces): ");
			exp = sc.nextLine();
			boolean verify = verifyInput(exp);
			if(!verify) {
				System.out.println("Try again");
				continue;
			}
			break;
		}
		return exp;
	}
	
	//Method that receives a string as a parameter
	//and checks if the expression in the string is valid.
	//Returns true if the expression is valid and false if it isn't
	public static boolean verifyInput(String expression){
		CharStack s = new CharStack(64);
		char currentChar;
		boolean controlVariable = false; //true - last char was a letter // false - last char was an operator
		for (int i = 0 ; i < expression.length() ; i++) {
			currentChar = expression.charAt(i);
			if (currentChar == '(') {
                s.push(')'); 
            }
			else if (currentChar == ')'){
                if (')' != s.pop()) {
                	System.out.println("Parenthesis mismatch");
                	return false; 
                }
              }
			else if (isLetter(currentChar) && controlVariable == false) {
				controlVariable = true;
				continue;
			}
			else if (isOperator(currentChar) && controlVariable == true) {
				controlVariable = false;
				continue;
			}
			else {
				System.out.println("Error - invalid order or character.");
				return false;
			}
		}
		return s.isEmpty();
	}
	
	public static float calculateOperation(float firstValue, float secondValue, char operator) {
		float result = 0;
		
		switch(operator) {
			case '+':
				result = firstValue + secondValue;
				break;
			case '-':
				result = firstValue - secondValue;
				break;
			case '*':
				result = firstValue * secondValue;
				break;
			case '/':
				result = firstValue / secondValue;
				break;
			case '^':
				result = (float) Math.pow(firstValue, secondValue);
				break;
		}
		
		return result;
	}
	
	//
	public static float postfixResult(String postfixExpression, int values[]) {
		float result = 0;
		FloatStack s = new FloatStack(8);
		
		float firstValue, secondValue;
		
		for(int i=0;i<postfixExpression.length();i++) {
			char currentChar = postfixExpression.charAt(i);
			if(isLetter(currentChar)) {
				s.push((values[currentChar-65]));
			}
				
			if(isOperator(currentChar)) {
				secondValue = s.pop();
				firstValue = s.pop();
				char operator = currentChar;
				float partialResult = calculateOperation(firstValue, secondValue, operator);
				System.out.println(partialResult);
				s.push(partialResult);
			}
		}
		
		return s.pop();
	}
	
	//
	public static void postfixEvaluation(String infixExpression, int values[]) {
		float result = 0;
		result = postfixResult(infixExpression, values);
		System.out.println("Expression result: " + result);
	}

	
	//Main method
	public static void main(String[] args) {
		//creating objects
		Scanner sc = new Scanner(System.in);
		
		//declaring variables
		String infixExpression = "";
		String postfixExpression = "";
		int opt = 0;
		
		//creating arrays to store variables values
		int values[] = new int[26];
		
		//loop to keep the menu running
		while(opt != 5){
			showMenu();
			
			System.out.print("Type your choice: ");
			try {
				opt = sc.nextInt();
			} catch(InputMismatchException e) {
				opt = 0;
				sc.nextLine();
			}
			
			switch(opt) {
				//read infix arithmetic expression
				case 1:
					infixExpression = writeExpression(sc);
					break;
					
				//read values for the variables in the expression
				case 2:
					readVariablesValues(sc, infixExpression, values);
					break;
					
				//converts the infix expression to a postfix expression
				case 3:
					//[TODO]
					sc.nextLine();
					postfixExpression = convertInfixToPostfix(infixExpression); //[TODO]
					System.out.println(postfixExpression);
					break;
					
				//evaluate and give the result to the expression
				case 4:
					//[TODO]
					postfixEvaluation(postfixExpression, values);
					break;
					
				//exit
				case 5:
					break;
					
				//default option that checks for invalid numbers
				default:
					System.out.println("Enter a valid option!");
					break;
			}	
		}
	}
}
