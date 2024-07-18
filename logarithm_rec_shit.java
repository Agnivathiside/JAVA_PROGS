import java.util.*;
public class logarithm_rec_shit {
    public static int logarithm(int x){
        if (x==1){
            return 0;
        }
        return 1+logarithm(x/2);//HOPE THIS IS ONLY THE FLOOR DIVISION IN JAVA
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the fucking number: ");
        int a=SC.nextInt();
        System.out.println("Here is your logarithmic value: "+logarithm(a));
        SC.close();

    }
    
}
