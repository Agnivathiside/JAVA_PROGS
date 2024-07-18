import java.util.*;
public class bit_manipulation_odd_even_shit {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a=sc.nextInt();
        if ((a & 1)==0){
            System.out.println("EVEN");
        }else{
            System.out.println("ODD");
        }
        sc.close();

    }
}
