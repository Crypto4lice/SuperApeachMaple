import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
	public String name; // ���� �̸��� ���� �����ϰ� public    ������ private
	private List items = new ArrayList();  // ���� ��Ʈ�� �߶� ���� ����
	private Scanner scanFile; // ��Ʈ�� ���� ��ĳ�� ��ü  [�ڸ��� ����(����)�� ���ϱ� ���� Scanner ���] 
	
	public Shop(String newName, String fileName) throws IOException{
		name = newName;
		scanFile = new Scanner(new BufferedReader(new FileReader(fileName)));
		//FileReader : ���� �ҷ����� Ŭ����,  BufferedReader : �ҷ��� ��Ʈ���� ���ۿ� �����ϰ� �ҷ����� Ŭ���� -- �Ŀ� �ڹ� å
	}
	
	public Shop(String newName, List newItems) {
		name = newName;
		items = newItems;
	}
	
	public void ReadDataFromFile() throws ItemTypeException {
		scanFile.useDelimiter("\n"); //��ĳ�ʿ� �ִ� �ڸ��� ���б��� �Լ�   -- �Ŀ� �ڹ� å
		
		String s = null;
		String s2 = null;
		
		while(scanFile.hasNext()) {
			s = scanFile.next();  // scanFile�� ���� �������� �ڸ�
			
			Scanner dev = new Scanner(s);
			dev.useDelimiter(",");  //��ĳ�ʿ� �ִ� �ڸ��� ���б��� �Լ�
			
			s2 = dev.next();
			
			if(s2.equals("\"Weapon\"")) {
				List con = MakeItem(dev); // dev�� , �������� �߶� ����Ʈ �迭�� �������.
				
				Item w = new Weapon((String)con.get(0), (String)con.get(1), Integer.parseInt((String)con.get(2)),
						Integer.parseInt((String)con.get(3)), Integer.parseInt((String)con.get(4)));
				
				// ������ ��ü ����    Integer.parseInt -- http://nota.tistory.com/49
				
				this.AddItem(w);
			} else if(s2.equals("\"Armor\"")) {
				
				List con = MakeItem(dev);
				
				Item a = new Armor((String)con.get(0), (String)con.get(1), Integer.parseInt((String)con.get(2)),
						Integer.parseInt((String)con.get(3)), Integer.parseInt((String)con.get(4)));
				//a.Describe();
				this.AddItem(a);
			} else if(s2.equals("\"Potion\"")) {
				
				List con = MakeItem(dev);
				
				Item p = new Potion((String)con.get(0), (String)con.get(1), Integer.parseInt((String)con.get(2)),
						Integer.parseInt((String)con.get(3)), (String)con.get(4), Integer.parseInt((String)con.get(5)));
				//p.Describe();
				this.AddItem(p);
			} else {
				throw new ItemTypeException();
			}
			
		}
	}
	
	private List MakeItem(Scanner dev) { //���� �������� ���پ� ���� ���ڽ�Ʈ���� , �������� �ڸ���
		                                  // �ʿ���� " ��   ���� ������ ��� �����
		                                 //  ����Ʈ �迭�� �־���.
		List con = new ArrayList();
		String temp = null; // �ʿ���� ���� ����� ���� �ӽ� ����
		int i=0;
		while(dev.hasNext()) {
			temp = dev.next();
			temp = temp.trim(); // �Ǿ��̳� �� ���� ������ ������.  -- http://nota.tistory.com/49
			temp = temp.replace("\"", "");  // " ������
			con.add(temp);  // ����Ʈ �迭�� �߰�
			i++;				
		}		
		
		return con;

// �迭�� ������ �ڵ�(�� �ڵ�) �������� �Ҵ� ���ؼ� ����.
		
		/*String [] con = new String[6];
		int i=0;
		while(dev.hasNext()) {
			con[i] = new String(dev.next());
			con[i] = con[i].trim();
			con[i] = con[i].replaceAll("\"", "");
			i++;
		}*/
		
		//Item w = new Weapon(con[0], con[1], Integer.parseInt(con[2]), Integer.parseInt(con[3]), Integer.parseInt(con[4]));

	}
	
	public void AddItem(Item i) {
		items.add(i);   // ������ �������� ������ ����Ʈ�� �߰�
	}
	
	public void ShowItemList() {
		int listLen = items.size();
		
		System.out.println("- Item List -");
		System.out.println();
		
		for(int i=0;i<listLen;i++) {
			Item showItem = (Item)items.get(i);
			showItem.Describe();
			System.out.println();
		}
	}
}
