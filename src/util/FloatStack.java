package util;

public class FloatStack {
	//defining a constant for capacity
	private final int STACK_CAPACITY = 256;
	
	//declaring variables
	private float data[];
	private int top;
	
	//constructors methods
	public FloatStack () {
		data = new float[STACK_CAPACITY];
		top = 0;
	}
	
	public FloatStack (int size) {
		data = new float[size];
		top = 0;
	}
	
	//fundamental stack methods
	public void push(float input) {
		if(!isFull()) {
			data[top] = input;
			top++;
		}
	}
	
	public float pop() {
		if(!isEmpty()) { 
			top--;
			float pop = data[top];
			data[top] = ' ';
			
			return pop;
		}
		
		else {
			return ' ';
		}
	}
	
	public float top() {
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