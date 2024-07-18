//MATRIX ADDITION
import java.util.*;
public class matrix_shit_4 {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter the no of rows of any matrix: ");
        int mat_1_row= SC.nextInt();
        System.out.print("Enter the no of columns of that matrx: ");
        int mat_1_col= SC.nextInt();
        int[][] mat_1=new int [mat_1_row][mat_1_col];
        int[][] mat_2=new int [mat_1_row][mat_1_col];
        int[][] mat_3=new int [mat_1_row][mat_1_col];
        for (int i=0;i<mat_1.length;i++){
            for (int j=0;j<mat_1[i].length;j++){
                System.out.print("Enter value for position "+"("+i+","+j+")"+"for matrix 1: ");
                mat_1[i][j]=SC.nextInt();
                System.out.print("Enter value for position "+"("+i+","+j+")"+"for matrix 2: ");
                mat_2[i][j]=SC.nextInt();
                mat_3[i][j]=mat_1[i][j] + mat_2[i][j];

            }
        }
        for (int i=0;i<mat_3.length;i++){
            for (int j=0;j<mat_3[i].length;j++){
                System.out.print(mat_3[i][j]+" ");
            }
            System.out.print("\n");
        }
        
        SC.close();
    }
}
