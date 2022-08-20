package shelter;

public class Queue<T> {
	//Variables
	private T queue[];
	private int head;
	private int tail;
	private int capacity;
	private int size;
	//Constructor
	@SuppressWarnings("unchecked")
	public Queue(int capacity){
	this.queue = (T[]) new String[capacity];
	this.capacity = capacity;
	this.head = this.tail = 0;
	this.size = 0;
	}
	public boolean isEmpty() {
		return this.size == 0;
	}
	public boolean isFull() {
		return this.size == this.capacity;
	}
	// Returns true false boolean according to success.
	@SuppressWarnings("unchecked")
	public boolean enqueue(String string) {
		if(!isFull()) {
		this.queue[this.tail] = (T) string;
		this.tail = (this.tail + 1)%capacity;
		this.size += 1;
		return true;
		}else {
			System.out.print("It is full you can not add");
			return false;
		}
	}
	// Returns a value if it is successful or returns null.
	public T dequeue() {
		if(!isEmpty()) {
			T removedData = this.queue[this.head];
			this.queue[this.head] = null;
			this.head = (head+1)%capacity;
			this.size -= 1;
			return removedData;
		}
		else {
			System.out.print("Queue is empty you can not remove!");
			return null;
		}
	}
	public T peek() {
		if(!isEmpty()) {
			return this.queue[head];
		}
		return null;
		
	}
	public int getSize() {
		return this.size;
	}
	public int setSize(int size) {
		this.size = size;
		return this.size;
	}
	public void show() {
		System.out.print("Elements : ");
		for(int i=0;i<this.capacity;i++) {
			System.out.print(queue[(head+i)%capacity] + " ");
		}
		System.out.println("");
	}
}
