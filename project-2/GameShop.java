import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GameShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EquipmentShop WAShop=null;
		PotionShop PShop=null;
		
		Shop selShop = null;
		
		try {
			WAShop = new EquipmentShop("Weapon/Armor Shop", "equip_item.txt");
			PShop = new PotionShop("Potion Shop", "potion_item.txt");
			//무기방어구 상점에는 장비텍트스 파일넘겨서, 포션 상점에는 포션텍스트 파일 넘겨서 생성
			
			WAShop.ReadDataFromFile();
			PShop.ReadDataFromFile();
			//파일 읽어서 아이템리스트 작성	
			
			}
			catch (IOException e) {
				System.err.println(e.getMessage() + "\n 파일을 찾을 수 없습니다.");
				//파일 못 불렀을시 에러 처리
			}
			catch (ItemTypeException e) {
				System.err.println(e.getMessage());
				//다른 아이템 타입 들어왔을시 에러 처리
			}
		
		Scanner s = new Scanner(System.in);
		

		

		
		while(true) { //게임 샵 전체메뉴
			System.out.println("- Shop Select -");
			System.out.println("\t 1. Weapon/Armor Shop");
			System.out.println("\t 2. Potion Shop");
			System.out.println("\t 3. Exit");
			System.out.println("\nSelect : ");
			int selNum = s.nextInt();
			
			switch(selNum) {
			case 1:
				ShopMenu(WAShop); // 하위 샵 메뉴
				break;
			case 2:
				ShopMenu(PShop);
				break;
			case 3:
				System.exit(0); // 프로세스 종료  --http://mwultong.blogspot.com/2007/03/java-main-return-exit-code.html
			default:
				System.out.println("Wrong number.");
			}
		
		}
		
		
	}

	
	public static void ShopMenu(Shop selShop) { //하위 샵 메뉴
		Scanner s = new Scanner(System.in);
		

		
		while(true) {
			
			System.out.println("Welcome to " + selShop.name + " Shop!");
			System.out.println("-----------------------------------");
			System.out.println("1. Show Item List");
			System.out.println("2. Exit");
		
			System.out.println("\nSelect : ");
			int selNum = s.nextInt();
		
		
			switch(selNum) {
			case 1:
				selShop.ShowItemList();
				break;
			case 2:
				return;
			default:
				System.out.println("Wrong number.\n");
			}
		
		}
	}
}
