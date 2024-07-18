import java.util.*;
public class factorial_rec_shit {
    public static int factorial_rec(int a){
        if (a==0){
            return 1;
        }
        return a * factorial_rec(a-1);
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the number idiot!!: ");
        int a=SC.nextInt();
        System.out.println("Here is your factorial: "+factorial_rec(a));
        SC.close();

    }
}
