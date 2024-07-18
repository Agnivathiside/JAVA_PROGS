import java.util.*;
public class steps_of_zeros_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter how many rows: ");
        int a=SC.nextInt();
        for (int i=0;i<a;i++){
            for (int j=0;j<=i;j++){
                System.out.print(0);
            }
            System.err.print("\n");
        }
        SC.close();
    }
}
