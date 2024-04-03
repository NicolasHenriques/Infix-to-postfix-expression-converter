//Code made by:
// - Marco Antonio de Camargo      | RA: 10418309
// - Natan Moreira Passos          | RA: 10417916
// - Nicolas Henriques de Almeida  | RA: 10418357
//References:
// - https://profkishimoto.github.io/edi03d-2024-1/atividades/n1/EDI-2024.1%20-%20Apl1.pdf
// - https://www.calcont.in/Calculator/Postfix_calculator/

package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import util.Stack;

public class Program {
	
	//method that prints the menu to the user
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
	
	
	//method that converts from infix to postfix
public static String convertInfixToPostfix(String ie) {
  //creating stack object
  Stack postfixExpression = new Stack();

  //creating String variable that will be returned
  String postfix = "";
  //creating variable to store the priority of an operand
  int previousPriority = 0;

  for(int i=0;i<ie.length();i++) {
    if(isAlphanumeric(ie.charAt(i))){
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


public static boolean isAlphanumeric(char check) { //check if the character is alphanumeric
    return (check >= 65 && check <= 90) ||
            (check >= 97 && check <= 122) ||
            (check >= 48 && check <= 57);
}
public static boolean isOperator(char check) { //check if the character is an operand
  return check=='+'||check=='-'||check=='*'||check=='/'||check=='^';
}
public static int priorityCheck(char check) { //se the "priority level" of the character
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

	
	//main method
	public static void main(String[] args) {
		//creating objects
		Scanner sc = new Scanner(System.in);
		
		//declaring variables
		String infixExpression;
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
					convertInfixToPostfix("A*B+C"); //[TODO]
					break;
					
				//read values for the variables in the expression
				case 2:
					//[TODO]
					break;
					
				//converts the infix expression to a postfix expression
				case 3:
					//[TODO]
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
