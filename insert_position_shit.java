import java.util.*;
public class insert_position_shit {
    public static void insertInArray(int[] arr, int num){
        int start=0;
        int end = arr.length-1;
        int mid=start+(end-start)/2;

        
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("How many numbers fucker");
        int count=sc.nextInt();
        int[] arr= new int[count];
        System.out.println("Enter the number");
        int num = sc.nextInt();

        int i=0;
        while (i<count){
            System.out.println("Enter the number");
            num=sc.nextInt();
            arr[i]=num;
        }

        Arrays.sort(arr);
        System.out.println("What number to be inserted");
        int number=sc.nextInt();
        insertInArray(arr, number);
        System.out.println("Print the array "+arr);

    }
}
