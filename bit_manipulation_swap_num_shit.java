import java.util.*;
public class bit_manipulation_swap_num_shit {
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a =SC.nextInt();
        System.out.print("Enter second number: ");
        int b=SC.nextInt();
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("Numbers are swaped !");
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        SC.close();
    }
}
