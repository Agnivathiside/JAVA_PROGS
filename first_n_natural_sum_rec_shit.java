import java.util.*;
public class first_n_natural_sum_rec_shit {
    public static int summation(int n){
        if(n==0){
            return 0;
        }
        return n+summation(n-1);

    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the number idiot!!: ");
        int a=SC.nextInt();
        System.out.print(summation(a));
        SC.close();

    }
    
}
