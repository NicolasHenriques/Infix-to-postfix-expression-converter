//Code made by:
// - Marco Antonio de Camargo      | RA: 10418309
// - Natan Moreira Passos          | RA: 10417916
// - Nicolas Henriques de Almeida  | RA: 10418357
//References:
// - https://profkishimoto.github.io/edi03d-2024-1/atividades/n1/EDI-2024.1%20-%20Apl1.pdf

package application;

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
		String postfix;
		
		for(int i=0;i<ie.length();i++) {
			
		}
		
		return "";
	}
	
	//main method
	public static void main(String[] args) {
		//creating objects
		Scanner sc = new Scanner(System.in);
		
		//declaring variables
		String infix_expression;
		int opt;
		
		//reading user input
		infix_expression = sc.nextLine();

		
		while(true){
			showMenu();
			System.out.println("Type your choice: ");
			opt = sc.nextInt();
			if(opt == 1){

			}
			else if(opt == 2){

			}
			else if(opt == 3){

			}
			else if(opt == 4){

			}
			else if(opt == 5){

			}
			else{

			}
		}
		
		
	}
}
