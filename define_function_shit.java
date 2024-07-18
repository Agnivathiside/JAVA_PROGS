import java.util.*;
public class define_function_shit {
    public static void main(String[] args){
        Scanner Agniva =new Scanner(System.in);
        System.out.println("Enter a number:");
        float a=Agniva.nextFloat();
        if (0 < a && 10<a){
            float ans = a+2;
            System.out.println("Here is your function output "+ans);

        }else if(10<=a){
            float ans = a*a + 2;
            System.out.println("Here is your function output "+ans);
        }else{
            System.out.println(0);

        }
        Agniva.close();
    }
}
