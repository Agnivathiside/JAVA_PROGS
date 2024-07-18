import java.util.*;
public class find_transition_point_shit {
    public static int transitionPoint(int arr[], int n) {
        // code here
        int a=Arrays.binarySearch(arr, 1);
        if (a<0){
            return -1;
        }
        return a-1;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int[] arr={0,0,0,0,0};
        System.out.println(transitionPoint(arr, 9));
        sc.close();
    }
}
