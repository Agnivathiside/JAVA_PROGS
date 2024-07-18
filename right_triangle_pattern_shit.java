import java.util.*;
public class right_triangle_pattern_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the Trisngle lenght you want: ");
        int a= SC.nextInt();
        for(int i=1;i<=a;i++){
            //1st inner loop--> for space printing
            for (int j=1;j<=a-i;j++){
                System.out.print(" ");
            }
            //2nd inner loop --> for star printing
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        SC.close();
    }
}
