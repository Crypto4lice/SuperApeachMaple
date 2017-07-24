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
			//����� �������� �����Ʈ�� ���ϳѰܼ�, ���� �������� �����ؽ�Ʈ ���� �Ѱܼ� ����
			
			WAShop.ReadDataFromFile();
			PShop.ReadDataFromFile();
			//���� �о �����۸���Ʈ �ۼ�	
			
			}
			catch (IOException e) {
				System.err.println(e.getMessage() + "\n ������ ã�� �� �����ϴ�.");
				//���� �� �ҷ����� ���� ó��
			}
			catch (ItemTypeException e) {
				System.err.println(e.getMessage());
				//�ٸ� ������ Ÿ�� �������� ���� ó��
			}
		
		Scanner s = new Scanner(System.in);
		

		

		
		while(true) { //���� �� ��ü�޴�
			System.out.println("- Shop Select -");
			System.out.println("\t 1. Weapon/Armor Shop");
			System.out.println("\t 2. Potion Shop");
			System.out.println("\t 3. Exit");
			System.out.println("\nSelect : ");
			int selNum = s.nextInt();
			
			switch(selNum) {
			case 1:
				ShopMenu(WAShop); // ���� �� �޴�
				break;
			case 2:
				ShopMenu(PShop);
				break;
			case 3:
				System.exit(0); // ���μ��� ����  --http://mwultong.blogspot.com/2007/03/java-main-return-exit-code.html
			default:
				System.out.println("Wrong number.");
			}
		
		}
		
		
	}

	
	public static void ShopMenu(Shop selShop) { //���� �� �޴�
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
