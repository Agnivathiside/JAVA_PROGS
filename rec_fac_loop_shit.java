import java.util.*;
public class rec_fac_loop_shit {
    public static long rec_fac(long num){
        long prod=1;
        for (long i=1;i<=num;i++){
            prod=prod*i;
        }
        return prod;
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter your big ass number: ");
        long a=SC.nextLong();
        long ans=rec_fac(a);
        System.out.println(ans);
        SC.close();
    }
}
