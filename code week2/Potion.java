
public class Potion extends Item {

	private String type;
	private int capacity;
	
	// �� �ȹٲ��
	
	public Potion(String newName, String newDescription, int newWeight, int newValue, String newType, int newCapacity) {
		super(newName, newDescription, newWeight, newValue);
		type = newType;
		capacity = newCapacity;
		// TODO Auto-generated constructor stub
	}

	public void Describe() {
		super.Describe();
		System.out.println("Type : " + type);
		System.out.println("Capacity : " + capacity);
	}
	
}
