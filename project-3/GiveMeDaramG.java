import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class GiveMeDaramG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Scanner s = new Scanner(System.in);


		System.out.println("맵의 크기 N을 입력하세요.(자연수로)");
		
		int N = s.nextInt(); //N 값을 받아옴. (맵 크기 받아오기)
		System.out.println("Okay. 입력됨.");
		System.out.println("맵을 그려주세요. (한줄에 "+N+"개 만큼)");
		s.nextLine();   // s에 남아있는 \n 버퍼를 지우기 위해 한줄 꺼내옴.
		                // nextLine이 아닌 nextInt 등은 \n 공백문자를 출력하지 않아 버퍼에 남기니 지워줘야됨.
		

		StringBuffer[] board = new StringBuffer[N];  // 문자열 안의 내용을 인덱스를 지정해서 치환하는 함수 replace(int,int,String)을 
		                                             // 사용하기 위해 StringBuffer를 사용.(StringBuilder를 사용해도 무방)
		                                             //  최신 jdk일수록 Buffer와 Builder가 서로 비슷해지므로 상관없음.
		                                             // String에는 인덱스를 지정해서 치환하는 함수가 없음.
		
		

		
		for(int i=0; i<N; i++) {  // 한줄씩 맵 정보 받아오기.  N칸이 아니면 다시 입력하게 만듬.
			board[i] = new StringBuffer(s.nextLine());
			if(board[i].length() != N) {
				System.out.println("The line length is wrong. Please input "
						 + N + " characters.");
				i--;
			}
		}
		
		
		int cNum=0;  //C갯수
		int dNum=0;  //D갯수
		
		Random rd = new Random();  // 무작위 위치로 D를 맵에 찍기 위한 랜덤함수
		int startPoint = (int)(rd.nextDouble() * (N*N-1)); // D를 찍기위해 맵을 탐색하는 시작점.
		
//		System.out.println(startPoint);
		
		
		for(int i=0;i<N;i++) {   // 맵을 (0,0)부터 (N,N)까지 한 바퀴 탐색하여 C와 D갯수를 셈.
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
		
		System.out.println("\nC의 갯수 : " + cNum + "\tD의 갯수 : " + dNum);
		
		int makeD=0; //모자란 D의 갯수
		
		if(cNum>0 && dNum < cNum * 2)
			makeD = cNum * 2 - dNum;
		
		System.out.println("D가 " + makeD + "개 만큼 모자랍니다. 추가좀");
		

	
		int point = startPoint;  // 맵의 좌표 ( (0,0) ~ (N,N)을  0 ~ N*N 의 숫자로 각각 메김.
		                         // 초기화는 랜덤한 맵의 탐색 시작점.
		

		int j=dNum + cNum;  //j는 반복이 끝나기전  못채운 D를 마지막에 몰아서 채우기 위한  숫자. 빈칸을 (D를 입력하던 안하던) 지나가면 +1.
	                        //마지막 남은 빈칸(.) 갯수 = (총 칸 수 - 채워져있는칸)
		
		
		for(int i=0;i<N*N;i++) {  // 맵을 시작점부터 한바퀴 탐색하여    모자란 D를 찍어주기 위한 반복.  만약 D를 다 찍었다면 바로 반복구문 탈출.
			
			if(board[point/N].charAt(point%N) == 'C' || board[point/N].charAt(point%N) == 'D') { // C,D이면 다음칸으로 넘김
				point++; //다음 좌표로
				if(point==N*N)  //만약 현재좌표가 마지막좌표면 처음으로 돌아감.
					point=0;
			}
			else {
				
			if(rd.nextInt(100)+1 < 15) { // 현재 좌표에 D를 랜덤으로 찍게 해줌. 확률을 15%로 지정
				board[point/N].replace(point%N, point%N + 1, "D");
				makeD--;
			}

			
			if(makeD==0) // 더이상 찍을 D가 없다면 탈출
				break;
			
			if(N*N-j==makeD) {  // 여기가  빈칸이랑 남은 D갯수를 비교해서 마지막 탐색부분에 몰아서 찍는 코드
				board[point/N].replace(point%N, point%N + 1, "D");
				makeD--;
			}
			
			
				
			j++;
			point++;
			if(point==N*N)
				point=0;
			
			}
			
			
		}
		
		System.out.println("\n 업데이트 된 맵");
		
		for(int i=0;i<N;i++) // 출력
			System.out.println(board[i]);
			
	}

}
