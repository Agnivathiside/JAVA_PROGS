// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5
// 1 2 3 4
// 1 2 3
// 1 2
// 1
import java.util.*;
public class some_wierd_pattern_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter how many rows idiot!: ");
        int a=SC.nextInt();
        for (int i=1;i<a+1;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
        for (int i=a-1;i>0;i--){
            for (int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
        SC.close();
    }
}
