import java.util.*;
public class twoDArray_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many rows?: ");
        int num_row=SC.nextInt();
        System.out.println("How many columns?: ");
        int num_col=SC.nextInt();
        int[][]numbers=new int[num_row][num_col];
        for (int i=0;i<num_row;i++){
            for (int j=0;j<num_col;j++){
                System.out.println("Enter valur for the location--> "+'('+i+','+j+')');
                numbers[i][j]=SC.nextInt();
            }
        }
        System.out.println("Here is your Matrix");
        for (int i=0;i<num_row;i++){
            for (int j=0;j<num_col;j++){
                System.out.print(numbers[i][j]+" ");
            }
            System.out.println();
        }
        SC.close();
    }
}
