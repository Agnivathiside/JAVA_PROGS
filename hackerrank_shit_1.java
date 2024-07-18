//https://www.hackerrank.com/challenges/java-loops/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
import java.util.*;
public class hackerrank_shit_1 {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter how many times: ");
        int a1 =SC.nextInt();
        int a=0, b=0, n=0, first_element=0;
        for (int i=0;i<a1;i++){
            a =SC.nextInt();
            b =SC.nextInt();
            n =SC.nextInt();
            first_element = (int) (a+Math.pow(2, 0)*b);
            for (int j=1;j<=n;j++){
                System.out.print(first_element+" ");
                first_element=(int) (first_element+(Math.pow(2, j)*b));

            }
            System.out.print("\n");
        }
        SC.close();

    }
}
