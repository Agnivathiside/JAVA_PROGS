import java.util.*;
public class finding_number_twoDarray_shit {
    public static void main(String[] args){
        Scanner SC =new Scanner(System.in);
        boolean flag=false;
        System.out.println("How many rows?: ");
        int num_row=SC.nextInt();
        System.out.println("How many columns?: ");
        int num_col=SC.nextInt();
        int [][]numbers=new int[num_row][num_col];
        for (int i=0;i<num_row;i++){
            for (int j=0;j<num_col;j++){
                System.out.println("Enter valur for the location--> "+'('+i+','+j+')');
                numbers[i][j]=SC.nextInt();
            }
        } 
        System.out.print("Enter the number you want to search in the matrix: ");
        int a=SC.nextInt();
        for (int i=0;i<num_row;i++){
            for (int j=0;j<num_col;j++){
                if (numbers[i][j]==a){
                    System.out.print("Number is found at the index--> "+'('+i+','+j+')');
                    flag=true;
                    break;
                }
            }
            //break;(NO CHANGES IN THE OUPUT WHILE RUNNING BUT WHY THIS WARNING)
        }
        if(flag==false){
            System.out.println("NUMBER NOT FOUND");
        }
        SC.close();
    }
}
