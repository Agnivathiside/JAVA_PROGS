import java.util.*;
public class solid_rectangle_pattern_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Lenght of the rectangle you want: ");
        int a=SC.nextInt();
        System.out.println("Breath of the rectangle you want: ");
        int b=SC.nextInt();
        for (int i=0; i<a;i++){
            for (int j=0; j<b;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        SC.close();
    }
}
