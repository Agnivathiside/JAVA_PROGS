// public class transition_point_shit

//{ Driver Code Starts
import java.util.*;

public class transition_point_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends

class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        int start=0;
        int end = n-1;
        int mid=start+(end-start)/2;

        while(end>=start){
            if (arr[mid]==0) start=mid+1;
            else if(arr[mid]==1){
                if (mid==0 || arr[mid-1]==0){
                    return mid;
                }
                end=mid-1;
            }
            mid=start+(end-start)/2;
        }
        return -1;
    }
}