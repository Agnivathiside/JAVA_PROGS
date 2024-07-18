import java.util.*;
public class factorial_shit {
    public static int factorial(int a){
        if (a<0){
            return -108;//basically my way of saying INVALID
        }
        int fac=1;
        for (int i=a;i>=1;i--){
            fac=fac*i;
        }
        return fac;
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int a=SC.nextInt();
        System.out.println("Here is your result: "+factorial(a));
        SC.close();
    }
}
