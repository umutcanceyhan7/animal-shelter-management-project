package shelter;

public  interface IRoom<T> {
	public boolean dequeueAny();
	public boolean dequeueDog();
	public boolean dequeueCat();
	public boolean enqueueDog(T dog);
	public boolean enqueueCat(T cat);
}
