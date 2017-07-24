
public class Armor extends Item {

	private int defense;
	
	//°ª ¾È¹Ù²î°Ô
	
	public Armor(String newName, String newDescription, int newWeight, int newValue, int newDefense) {
		super(newName, newDescription, newWeight, newValue);
		defense = newDefense;
		// TODO Auto-generated constructor stub
	}
	
	public void Describe() {
		super.Describe();
		System.out.println("Defense = " + defense);
	}
	
}
