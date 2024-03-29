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
		Stack postfix_expression = new Stack();
		
		//creating String variable that will be returned
		String postfix = "";
		
		for(int i=0;i<ie.length();i++) {
			
		}
		
		return postfix;
	}
	
	//main method
	public static void main(String[] args) {
		//creating objects
		Scanner sc = new Scanner(System.in);
		
		//declaring variables
		String infix_expression;
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
					break;
					
				//read values for the variables in the expression
				case 2:
					break;
					
				//converts the infix expression to a postfix expression
				case 3:
					break;
					
				//evaluate and give the result to the expression
				case 4:
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
