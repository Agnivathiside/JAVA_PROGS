// MATRIX MULTIPLICATION
import java.util.*;
public class matrix_shit_5 {
    public static Integer[][] create_zero_matrix(int x,int y){
        //Scanner SC=new Scanner(System.in);
        Integer[][] result=new Integer[x][y];
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                result[i][j]=0;
            }
        }
        return result;
    }
    public static Integer multiplication_cantre(Integer[][] mat1, Integer[][] mat2){
        Integer mat[][];
        mat=create_zero_matrix(mat1.length, mat2[0].length);
        for (int i=0;i<mat1.length;i++){
            for (int j=0;j<mat2[0].length;j++){
                for (int k=0;k<mat2.length;k++){
                    mat[i][j]+= mat1[i][k] * mat2[k][j];
                }
            }
        }
        return display(mat);
    }
    public static Integer input_matrix(int a, int b, int c){
        Scanner SC=new Scanner(System.in);
        Integer[][] mat_1=new Integer[a][b];
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                System.out.print("Emter valur for matrix 1: ");
                mat_1[i][j]=SC.nextInt();
            }
        }
        Integer[][] mat_2=new Integer[b][c];
        for (int i=0;i<b;i++){
            for (int j=0;j<c;j++){
                System.out.print("Emter valur for matrix 2: ");
                mat_2[i][j]=SC.nextInt();
            }
        }
        SC.close();
        return multiplication_cantre(mat_1, mat_2);

    }
    public static Integer display(Integer mat[][]){
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.print("\n");
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter no of rows in Matrix 1: ");
        int a =SC.nextInt();
        System.out.println("Enter no of columns in Mtrix 1: ");
        int b =SC.nextInt();
        System.out.println("Enter no of columns in matrix 2: ");
        int c =SC.nextInt();
        System.out.println(input_matrix(a, b, c));
        SC.close();
    }
}
