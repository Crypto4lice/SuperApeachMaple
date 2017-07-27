import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class GiveMeDaramG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Scanner s = new Scanner(System.in);


		System.out.println("���� ũ�� N�� �Է��ϼ���.(�ڿ�����)");
		
		int N = s.nextInt(); //N ���� �޾ƿ�. (�� ũ�� �޾ƿ���)
		System.out.println("Okay. �Էµ�.");
		System.out.println("���� �׷��ּ���. (���ٿ� "+N+"�� ��ŭ)");
		s.nextLine();   // s�� �����ִ� \n ���۸� ����� ���� ���� ������.
		                // nextLine�� �ƴ� nextInt ���� \n ���鹮�ڸ� ������� �ʾ� ���ۿ� ����� ������ߵ�.
		

		StringBuffer[] board = new StringBuffer[N];  // ���ڿ� ���� ������ �ε����� �����ؼ� ġȯ�ϴ� �Լ� replace(int,int,String)�� 
		                                             // ����ϱ� ���� StringBuffer�� ���.(StringBuilder�� ����ص� ����)
		                                             //  �ֽ� jdk�ϼ��� Buffer�� Builder�� ���� ��������Ƿ� �������.
		                                             // String���� �ε����� �����ؼ� ġȯ�ϴ� �Լ��� ����.
		
		

		
		for(int i=0; i<N; i++) {  // ���پ� �� ���� �޾ƿ���.  Nĭ�� �ƴϸ� �ٽ� �Է��ϰ� ����.
			board[i] = new StringBuffer(s.nextLine());
			if(board[i].length() != N) {
				System.out.println("The line length is wrong. Please input "
						 + N + " characters.");
				i--;
			}
		}
		
		
		int cNum=0;  //C����
		int dNum=0;  //D����
		
		Random rd = new Random();  // ������ ��ġ�� D�� �ʿ� ��� ���� �����Լ�
		int startPoint = (int)(rd.nextDouble() * (N*N-1)); // D�� ������� ���� Ž���ϴ� ������.
		
//		System.out.println(startPoint);
		
		
		for(int i=0;i<N;i++) {   // ���� (0,0)���� (N,N)���� �� ���� Ž���Ͽ� C�� D������ ��.
			for(int j=0; j<N; j++) {
				char con = board[i].charAt(j);
				if(con == 'C') {
					cNum++;
				}
				else if(con == 'D') {
					dNum++;
				}
			}
		}
		
		System.out.println("\nC�� ���� : " + cNum + "\tD�� ���� : " + dNum);
		
		int makeD=0; //���ڶ� D�� ����
		
		if(cNum>0 && dNum < cNum * 2)
			makeD = cNum * 2 - dNum;
		
		System.out.println("D�� " + makeD + "�� ��ŭ ���ڶ��ϴ�. �߰���");
		

	
		int point = startPoint;  // ���� ��ǥ ( (0,0) ~ (N,N)��  0 ~ N*N �� ���ڷ� ���� �ޱ�.
		                         // �ʱ�ȭ�� ������ ���� Ž�� ������.
		

		int j=dNum + cNum;  //j�� �ݺ��� ��������  ��ä�� D�� �������� ���Ƽ� ä��� ����  ����. ��ĭ�� (D�� �Է��ϴ� ���ϴ�) �������� +1.
	                        //������ ���� ��ĭ(.) ���� = (�� ĭ �� - ä�����ִ�ĭ)
		
		
		for(int i=0;i<N*N;i++) {  // ���� ���������� �ѹ��� Ž���Ͽ�    ���ڶ� D�� ����ֱ� ���� �ݺ�.  ���� D�� �� ����ٸ� �ٷ� �ݺ����� Ż��.
			
			if(board[point/N].charAt(point%N) == 'C' || board[point/N].charAt(point%N) == 'D') { // C,D�̸� ����ĭ���� �ѱ�
				point++; //���� ��ǥ��
				if(point==N*N)  //���� ������ǥ�� ��������ǥ�� ó������ ���ư�.
					point=0;
			}
			else {
				
			if(rd.nextInt(100)+1 < 15) { // ���� ��ǥ�� D�� �������� ��� ����. Ȯ���� 15%�� ����
				board[point/N].replace(point%N, point%N + 1, "D");
				makeD--;
			}

			
			if(makeD==0) // ���̻� ���� D�� ���ٸ� Ż��
				break;
			
			if(N*N-j==makeD) {  // ���Ⱑ  ��ĭ�̶� ���� D������ ���ؼ� ������ Ž���κп� ���Ƽ� ��� �ڵ�
				board[point/N].replace(point%N, point%N + 1, "D");
				makeD--;
			}
			
			
				
			j++;
			point++;
			if(point==N*N)
				point=0;
			
			}
			
			
		}
		
		System.out.println("\n ������Ʈ �� ��");
		
		for(int i=0;i<N;i++) // ���
			System.out.println(board[i]);
			
	}

}
