import java.util.*;
public class prime_shit {
    public static void main(String[] args) {
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter the upperbound: ");
        int num=SC.nextInt();
       
         int count;
       
         for (int i = 2; i <= num; i++) {
          count = 0;
          for (int j = 3; j <= i / 2; j++) {
           if (i % j == 0) {
            count++;
            break;
           }
          }
       
          if (count == 0) {
           System.out.println(i);
          }
       
         }
         SC.close();
    }
        
}
