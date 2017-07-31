import java.util.Scanner;

public class cs1{
  public static void main(String args[]){
      Scanner in = new Scanner(System.in);

      System.out.print("Please input the number of change : ");

      int T = in.nextInt();

      for(int i=0;i<T;i++){

        System.out.print("Input the number : ");
        int N = in.nextInt();

        N+=1;

        String Nstring = Integer.toBinaryString(N);
        Nstring = Nstring.substring(1);
        Nstring = Nstring.replace('0','4');
        String result = Nstring.replace('1','7');


        System.out.println("Result : " + result);
      }

  }
}
