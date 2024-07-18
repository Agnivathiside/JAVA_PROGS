import java.util.*;
public class bit_manipulaton_shifting_shit{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a=sc.nextInt();
        while (a!=0){
            a=a>>1;  // '<<' for multiplication
            System.out.println(a);
        }
        sc.close();
    }
}