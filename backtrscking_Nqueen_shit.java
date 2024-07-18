import java.util.*;
public class backtrscking_Nqueen_shit {
    public static void Display(int boards[][], int row){
        if (NQueen(boards, row)){
            for (int i = 0; i <boards.length; i++) {
                for (int j = 0; j <boards.length; j++)
                    System.out.print(" " + boards[i][j]+ " ");
                System.out.println();
            }
        }
    }
    public static boolean isSafe(int boards[][], int row, int col){
        for (int i=0;i<row;i++){
            if(boards[i][col]==1){
                return false;
            }
        }
        for (int i=row,j=col;i>=0 && j>=0;i--,j--){
            if (boards[i][j]==1){
                return false;
            }
        }
        for (int i=row,j=col;i>=0 && j<boards.length;i--,j++){
            if (boards[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public static boolean NQueen(int boards[][], int row){
        if (row==boards.length){
            return true;
        }
        for (int col=0;col<boards.length;col++){
            if(isSafe(boards, row, col)){
                boards[row][col]=1;
                if (NQueen(boards, row+1)){
                    return true;
                }
                boards[row][col]=0;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int a= SC.nextInt();
        System.out.print("Enter the number of columns: ");
        int b= SC.nextInt();
        int[][] bo=new int[a][b];
        Display(bo, 0);
        SC.close();
    }
}
