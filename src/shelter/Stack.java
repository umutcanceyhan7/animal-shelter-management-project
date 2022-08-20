package shelter;

public class Stack<T> {
	//Variables
	private T arr[];
	private int top;
	private int capacity;
	//Constructor
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		// Could not convert array to generic type
		arr = (T[]) new String[capacity];
		this.capacity = capacity;
		top = -1;
	}
	public int size() {
		return top + 1;
	}
	public boolean isEmpty() {
		return top == -1;
		}
	public boolean isFull() {
		return top == capacity - 1;
	}
	public boolean push(T item) {
		if(!isFull()) {
			top = top + 1;
			arr[top] = item;
			return true;
		}
		System.out.println("Stack is full!");
		return false;
	}
	public T pop() {
		if(!isEmpty()) {
			T removedItem = arr[top];
			arr[top] = null;
			top = top - 1;
			return removedItem;
		}
		System.out.println("Stack is empty");
		return null;
	}
	public T peek() {
		if(!isEmpty()) {
			return arr[top];
		}
		System.out.println("Stack is empty");
		return null;
	}
	
}
