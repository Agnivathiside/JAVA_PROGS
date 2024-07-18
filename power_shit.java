import java.util.*;
public class power_shit {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the base in double form");
        double x = sc.nextDouble();
        System.out.println("Enter the power");
        int pow = sc.nextInt();

        System.out.println("result is "+Math.pow(x, pow));
        sc.close();
    }    
}
