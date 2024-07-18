import java.util.*;
public class starting_to_end_shit {
    public static int num_of_ways(int a, int b){
        if (a==1 || b==1){
            return 1;
        }
        return num_of_ways(a, b-1)+num_of_ways(a-1, b);
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row=SC.nextInt();
        System.out.print("Enter number of columns: ");
        int col=SC.nextInt();
        System.out.print("Total number of ways to go to end from Start is: "+num_of_ways(row, col));
        SC.close();

    }
}
