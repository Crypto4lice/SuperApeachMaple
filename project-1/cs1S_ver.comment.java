import java.util.Scanner;

public class cs1{
  public static void main(String args[]){
      Scanner in = new Scanner(System.in);

      System.out.print("Please input the number of change : ");

      int T = in.nextInt(); // 횟수 입력받기

      for(int i=0;i<T;i++){ // 횟수만큼 전체 반복

        System.out.print("Input the number : ");
        int N = in.nextInt(); // 우선 2진수로 변환할 숫자 받기

        N+=1; // 극단적인 수열과 시작점을 맞추기 위해 1 더하기

        String Nstring = Integer.toBinaryString(N); // 2진수로 변환
        Nstring = Nstring.substring(1); // 2진수의 불필요한 맨 앞자리 제거
        Nstring = Nstring.replace('0','4'); // 2진수에서 0->4, 1->7로 변환
        String result = Nstring.replace('1','7'); // 극단적인 수 완성


        System.out.println("Result : " + result); // 출력
      }

  }
}
/* toBinaryString 참조 : http://donggov.tistory.com/48
 substring 참조 : http://devbible.tistory.com/6
 replace 참조 : http://mwultong.blogspot.com/2006/10/java-string-replace-all.html*/
