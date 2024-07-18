//PROBLEM when user is asked to input numbers with space in between, with comma(,) no problem
//2*[[1,2],[3,4]]=[[2,4],[6,8]]
import java.util.*;
public class matrix_shit_3 {
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.println("Enter the Dimension: ");
        int a=SC.nextInt();
        Integer[][] mat=new Integer[a][a];
        for (int i=0;i<a;i++){
            String[] s=new String[a];
            
                System.out.println("Enter elements with comman in between");
                String str_num=SC.next();
                s=str_num.split(",");
                for (int j=0;j<s.length;j++){
                    mat[i][j]=Integer.parseInt(s[j]);
                }
            
        }
        System.out.println("Enter the multiplier: ");
        int x=SC.nextInt();
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[i].length;j++){
                mat[i][j]=mat[i][j] * x;
                System.out.print(mat[i][j]+ " ");
            }
            System.out.print("\n");
        }
        SC.close();
    }
}
