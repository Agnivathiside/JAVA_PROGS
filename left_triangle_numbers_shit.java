import java.util.*;
public class left_triangle_numbers_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("how many rows?: ");
        int a=SC.nextInt();
        for (int i=1;i<=a;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
        SC.close();
    }
}
