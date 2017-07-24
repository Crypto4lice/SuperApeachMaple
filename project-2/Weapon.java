
public class Weapon extends Item {

	private int damage; //마음대로 값이 안바뀌게 private
	
	public Weapon(String newName, String newDescription, int newWeight, int newValue, int newDamage) {
		super(newName, newDescription, newWeight, newValue);
		damage = newDamage;
		// TODO Auto-generated constructor stub
	}
	
	public void Describe() {
		super.Describe();
		System.out.println("Damage = " + damage);
	}
	

}
