import java.util.*;
public class multiplication_table_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int a =SC.nextInt();
        for (int i=1;i<=10;i++){
            System.out.println(a+" x "+i+" = "+(a*i));
        }
        SC.close();
    }
}
