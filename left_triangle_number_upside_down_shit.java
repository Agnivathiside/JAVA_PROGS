import java.util.*;
public class left_triangle_number_upside_down_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("how much bitch?: ");
        int a=SC.nextInt();
        //THIS BELOW CODE IS FOR THIS OUTPUT-->(FOR INPUT 5)
        // 54321
        // 5432
        // 543
        // 54
        // 5
        // for (int i=0;i<a;i++){
        //     for (int j=a;j>i;j--){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
        for (int i=a;i>=1;i--){
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
        //THIS ABOVE CODE IS FOR THIS OUTPUT-->(FOR INPUT 5)
        
        SC.close();
    }
}
