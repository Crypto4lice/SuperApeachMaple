import java.io.IOException;

public class PotionShop extends Shop {

	public PotionShop(String newName, String fileName) throws IOException {
		super(newName, fileName);
		// TODO Auto-generated constructor stub
	}

	public void AddItem(Item i) {
		if(i instanceof Potion) { // �Ű����� i�� ��ü�� Potion��ü��  Ŭ������ ��ġ�ϴ��� Ȯ����  (��ü�� �������� �ƴ϶� Ŭ������ �������� �Ǻ�) 
			                     //instanceof -- http://arer.tistory.com/52
			super.AddItem(i);
		}
	}
}
