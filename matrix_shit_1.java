//SOME REAL TROUBLE WITH THIS CODE ... LOGICAL TROUBLE !!
//Accept a square matrix as input and store it in a variable named matrix. 
//The first line of input will be, nn, the number of rows in the matrix.
// Each of the next nn lines will have a sequence of nn space-separated integers.
import java.util.*;
public class matrix_shit_1 {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the dimenssion");
        int a=SC.nextInt();
        Integer[][] matrix=new Integer[a][a];
        for (int i=0;i<a;i++){
            String[] m1=new String[a];
            System.out.print("Enter digits with spaces in between:");
            String num=SC.nextLine();
            m1=num.split(" ");
            for (int j=0;j<m1.length;j++){
                matrix[i][j]=Integer.parseInt(m1[j]);
            }
            
        }
        for (int i=0;i<a;i++){
            for (int j=0;j<a;j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.print("\n");
        }
        SC.close();
    }
}
