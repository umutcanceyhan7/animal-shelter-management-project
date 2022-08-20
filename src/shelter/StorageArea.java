package shelter;


public class StorageArea<T>{
	protected int cannedFood;
	protected int dryFood;
	protected int totalFood;
	protected boolean checker;
	protected Stack<T> storageArea;
	protected int capacity;
	public StorageArea(int capacity) {
		cannedFood = 0;
		dryFood = 0;
		totalFood = 0;
		storageArea = new Stack<T>(capacity);
		this.capacity = capacity;
	}
	public boolean donateFood(String food) {
		checker = false;
		if(food.equals("cannedfood")) {
			checker = donateCannedFood();
			updateTotalFood();
		}
		else if(food.equals("dryfood")) {
			checker = donateDryFood();
			updateTotalFood();
		}
		return checker;
		
	}
	public boolean takeFood() {
		if(!storageArea.isEmpty()) {
			T removedItem = storageArea.pop();
			if(removedItem.equals("cannedFood")) {
				cannedFood = getCannedFood() - 1;
				setCannedFood(cannedFood);
				updateTotalFood();
			}
			else {
				dryFood = getDryFood() - 1;
				setDryFood(dryFood);
				updateTotalFood();
			}
			return true;
		}
		System.out.println("Yemek yokkkk!");
		return false;
	}
	public int getCannedFood() {
		return this.cannedFood;
	}
	public void setCannedFood(int cannedFood) {
		this.cannedFood = cannedFood;
	}
	public int getDryFood() {
		return this.dryFood;
	}
	public void setDryFood(int dryFood) {
		this.dryFood = dryFood;
	}
	public int getTotalFood() {
		return this.totalFood;
	}
	public void setTotalFood(int totalFood) {
		this.totalFood = totalFood;
	}
	public void updateTotalFood() {
		this.totalFood = getDryFood() + getCannedFood();
		setTotalFood(totalFood);
	}
	@SuppressWarnings("unchecked")
	private boolean donateCannedFood() {
		if(!storageArea.isFull() && getTotalFood() < this.capacity) {
			storageArea.push((T) "cannedFood");
			cannedFood = getCannedFood() +1 ;
			setCannedFood(cannedFood);
			return true;
		}return false;
		
	}
	@SuppressWarnings("unchecked")
	private boolean donateDryFood() {
		if(!storageArea.isFull() && getTotalFood() < this.capacity) {
			storageArea.push((T) "dryFood");
			dryFood = getDryFood() + 1;
			setDryFood(dryFood);
			return true;
		}return false;
		
	}
}
