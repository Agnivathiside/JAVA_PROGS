import java.util.*;
public class hollow_rectangle_pattern_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the lengh of the rectangle you want: ");
        int a=SC.nextInt();
        System.out.println("Enter the breath of the rectangle you want: ");
        int b=SC.nextInt();
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                if ((1<=i && i<=a-2) && (1<=j && j<=b-2)){
                    System.out.print(" ");

                }
                else{
                   System.out.print("*");
                }
            }
            System.out.println();
        }
        SC.close();
    }
}
