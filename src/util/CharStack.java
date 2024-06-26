//Code made by:
// - Marco Antonio de Camargo      | RA: 10418309
// - Natan Moreira Passos          | RA: 10417916
// - Nicolas Henriques de Almeida  | RA: 10418357

package util;

public class CharStack {
	//defining a constant for capacity
	private final int STACK_CAPACITY = 256;
	
	//declaring variables
	private char data[];
	private int top;
	
	//constructors methods
	public CharStack () {
		data = new char[STACK_CAPACITY];
		top = 0;
	}
	
	public CharStack (int size) {
		data = new char[size];
		top = 0;
	}
	
	//fundamental stack methods
	public void push(char input) {
		if(!isFull()) {
			data[top] = input;
			top++;
		}
	}
	
	public char pop() {
		if(!isEmpty()) { 
			top--;
			char pop = data[top];
			data[top] = ' ';
			
			return pop;
		}
		
		else {
			return ' ';
		}
	}
	
	public char top() {
		if(!isEmpty()) { 
			return data[top-1];
		}
		
		else {
			return ' ';
		}
	}
	
	//extra stack methods
	public int size() {
		return data.length;
	}
	
	public int count() {
		return top;
	}
	
	public boolean isEmpty() {
		if(top == 0) return true;
		else return false;
	}
	
	public boolean isFull() {
		if (top == data.length) return true;
		else return false;
	}
	
	public void clear () {
		for(int i=top-1; i>=0; --i) {
			data[i] = 0;
		}
		top = 0;
	}
}