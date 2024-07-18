import java.util.*;
public class factorial_func_rec_shit {
    public static Integer fac_rec(int x){
        if (x==0){
            return 1;
        }
        return x*fac_rec(x-1);
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=SC.nextInt();
        System.out.print("Here is the ans--> "+fac_rec(a));
        SC.close();
    } 
}
