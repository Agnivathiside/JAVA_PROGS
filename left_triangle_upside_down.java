import java.util.*;
public class left_triangle_upside_down {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Length of the triangle you want it to: ");
        int a= SC.nextInt();
        for (int i=0;i<a;i++){
            for (int j=a;j>i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
        SC.close();
    }
}
