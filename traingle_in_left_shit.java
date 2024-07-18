import java.util.*;
public class traingle_in_left_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Triangle size you want: ");
        int a=SC.nextInt();
        for (int i=0;i<a;i++){
            for (int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        SC.close();
    }
}
