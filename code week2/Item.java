
public class Item {
	private String name;
	private String description;
	private int weight;
	private int value;
	
	// ��� ����� �� �ȹٲ��
	
	public Item(String newName, String newDescription, int newWeight, int newValue) {
		name = newName;
		description = newDescription;
		weight = newWeight;
		value = newValue;
	}
	public void Describe() {
		System.out.println("Name = " + name);
		System.out.println("Description = " + description);
		System.out.println("Weight = " + weight + " kg");
		System.out.println("Value = " + value + " gold");
	}
}
