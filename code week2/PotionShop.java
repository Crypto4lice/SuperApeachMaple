import java.io.IOException;

public class PotionShop extends Shop {

	public PotionShop(String newName, String fileName) throws IOException {
		super(newName, fileName);
		// TODO Auto-generated constructor stub
	}

	public void AddItem(Item i) {
		if(i instanceof Potion) { // 매개변수 i의 객체와 Potion객체의  클래스가 일치하는지 확인함  (객체가 같은지가 아니라 클래스가 같은지를 판별) 
			                     //instanceof -- http://arer.tistory.com/52
			super.AddItem(i);
		}
	}
}
