import java.io.IOException;

public class EquipmentShop extends Shop {

	public EquipmentShop(String newName, String fileName) throws IOException {
		super(newName, fileName);
		// TODO Auto-generated constructor stub
	}

	public void AddItem(Item i) {
		if(i instanceof Armor || i instanceof Weapon) {
			super.AddItem(i);
		}
	}
}
