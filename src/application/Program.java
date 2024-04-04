//Code made by:
// - Marco Antonio de Camargo      | RA: 10418309
// - Natan Moreira Passos          | RA: 10417916
// - Nicolas Henriques de Almeida  | RA: 10418357
//References:
// - https://profkishimoto.github.io/edi03d-2024-1/atividades/n1/EDI-2024.1%20-%20Apl1.pdf
// - https://www.calcont.in/Calculator/Postfix_calculator/
// - https://www.ascii-code.com
// - https://www.baeldung.com/java-check-string-contains-only-letters-numbers

package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import util.Stack;

public class Program {
	//method that receives no parameter and has
	//no return. Only used to show the menu
	//to the user.
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
	
	//method that receives an String containing an
	//infix expression, converts it to a postfix expression
	//and returns it in a String
	public static String convertInfixToPostfix(String ie) {
		//creating stack object
		Stack postfixExpression = new Stack();
	
		//creating String variable that will be returned
		String postfix = "";
		//creating variable to store the priority of an operand
		int previousPriority = 0;
	
		for(int i=0;i<ie.length();i++) {
			if(isLetter(ie.charAt(i))){
				System.out.print(ie.charAt(i));
			}
			else if(isOperator(ie.charAt(i))) {
				previousPriority = priorityCheck(postfixExpression.top()); //if an operand is found. Check if its priority is less/equal than the previous
				if(previousPriority >= priorityCheck(ie.charAt(i))){ //if it is, pop the last one from the stack and push the new one. If it isn't, just add the new one to the stack
					System.out.print(postfixExpression.pop());
				}
				postfixExpression.push(ie.charAt(i));
			}
			else if(ie.charAt(i) == '(') { //add ( to the stack
				postfixExpression.push(ie.charAt(i));
			}
			else if(ie.charAt(i) == ')') { //if an ) is found, pop everything until you find a (
				while(!postfixExpression.isEmpty() && postfixExpression.top() != '(') {
					System.out.print(postfixExpression.pop());
				}
				postfixExpression.pop(); 
			}
		}
		while(!postfixExpression.isEmpty()) { //pop the remaining elements of the stack
			System.out.print(postfixExpression.pop());
		}
		
		System.out.print("\n");
		return postfix;
	}

	//method that receives a char and checks
	//if it is an upper case letter.
	//returns true if it is, returns false if it isn't
	public static boolean isLetter(char check) { //check if the character is alphanumeric
		return (check >= 65 && check <= 90);
	}
	
	//method that receives a char and checks
	//if it is an arithmetic operator.
	//returns true if it is, returns false if it isn't
	public static boolean isOperator(char check) { //check if the character is an operand
		return check=='+'||check=='-'||check=='*'||check=='/'||check=='^';
	}
	
	//method that receives a char as a parameter
	//and checks it's priority.
	//returns the corresponding priority as an int
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
	
	//method that receives a scanner object as a parameter,
	//reads user input for the desired expression and 
	//returns the infix arithmetic expression as a String
	public static String writeExpression(Scanner sc) {
		sc.nextLine();
		String exp = "";
		while(true) {
			System.out.println("Type the expression: ");
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
	
	//method that receives a string as a parameter
	//and checks if the expression in the string is valid
	//returns true if the expression is valid and false if it isn't
	public static boolean verifyInput(String expression){
		Stack s = new Stack(64);
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

	
	//main method
	public static void main(String[] args) {
		//creating objects
		Scanner sc = new Scanner(System.in);
		
		//declaring variables
		String infix_expression = "";
		String postfix_expression = "";
		int opt = 0;
		
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
					infix_expression = writeExpression(sc);
					break;
					
				//read values for the variables in the expression
				case 2:
					//[TODO]
					break;
					
				//converts the infix expression to a postfix expression
				case 3:
					//[TODO]
					postfix_expression = convertInfixToPostfix(infix_expression); //[TODO]
					break;
					
				//evaluate and give the result to the expression
				case 4:
					//[TODO]
					break;
					
				//exit
				case 5:
					//[TODO]
					break;
					
				//default option that checks for invalid numbers
				default:
					System.out.println("Enter a valid option!");
					break;
			}	
		}
	}
}
