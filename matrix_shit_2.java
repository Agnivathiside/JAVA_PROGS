// CREATING AN IDENTITY MATRIX
import java.util.*;
public class matrix_shit_2 {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the Dimension of the matrix");
        int a=SC.nextInt();
        Integer[][] mat=new Integer[a][a];
        for (int i=0;i<a;i++){
            for (int j=0;j<a;j++){
                if (i==j){
                    mat[i][j]=1;
                }else if(i!=j){
                    mat[i][j]=0;
                }
            }
        }
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println("\n");
        }
        SC.close();
    }
}
