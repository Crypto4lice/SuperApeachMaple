import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
	public String name; // 상점 이름은 참조 가능하게 public    나머지 private
	private List items = new ArrayList();  // 받은 스트림 잘라서 넣을 공간
	private Scanner scanFile; // 스트림 받을 스캐너 객체  [자르는 구분(기준)을 정하기 위해 Scanner 사용] 
	
	public Shop(String newName, String fileName) throws IOException{
		name = newName;
		scanFile = new Scanner(new BufferedReader(new FileReader(fileName)));
		//FileReader : 파일 불러오는 클래스,  BufferedReader : 불러온 스트림을 버퍼에 저장하고 불러오는 클래스 -- 파워 자바 책
	}
	
	public Shop(String newName, List newItems) {
		name = newName;
		items = newItems;
	}
	
	public void ReadDataFromFile() throws ItemTypeException {
		scanFile.useDelimiter("\n"); //스캐너에 있는 자르는 구분기준 함수   -- 파워 자바 책
		
		String s = null;
		String s2 = null;
		
		while(scanFile.hasNext()) {
			s = scanFile.next();  // scanFile은 엔터 기준으로 자름
			
			Scanner dev = new Scanner(s);
			dev.useDelimiter(",");  //스캐너에 있는 자르는 구분기준 함수
			
			s2 = dev.next();
			
			if(s2.equals("\"Weapon\"")) {
				List con = MakeItem(dev); // dev는 , 기준으로 잘라서 리스트 배열에 집어넣음.
				
				Item w = new Weapon((String)con.get(0), (String)con.get(1), Integer.parseInt((String)con.get(2)),
						Integer.parseInt((String)con.get(3)), Integer.parseInt((String)con.get(4)));
				
				// 아이템 객체 생성    Integer.parseInt -- http://nota.tistory.com/49
				
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
	
	private List MakeItem(Scanner dev) { //엔터 간격으로 한줄씩 받은 문자스트림을 , 간격으로 자르고
		                                  // 필요없는 " 나   엔터 공백은 모두 지우고
		                                 //  리스트 배열에 넣어줌.
		List con = new ArrayList();
		String temp = null; // 필요없는 문자 지우기 위한 임시 변수
		int i=0;
		while(dev.hasNext()) {
			temp = dev.next();
			temp = temp.trim(); // 맨앞이나 맨 뒤의 공백을 지워줌.  -- http://nota.tistory.com/49
			temp = temp.replace("\"", "");  // " 지워줌
			con.add(temp);  // 리스트 배열에 추가
			i++;				
		}		
		
		return con;

// 배열로 했을대 코드(구 코드) 동적으로 할당 못해서 버림.
		
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
		items.add(i);   // 생성된 아이템을 아이템 리스트에 추가
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
