// public class maximum_index_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class maximum_index_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends

class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        if (n==1) return 0;

        int Lmin[]= new int[n];
        int Rmax[]= new int[n];

        Lmin[0]=arr[0];
        for(int i=1; i<n; i++){
            Lmin[i]=Integer.min(arr[i], Lmin[i-1]);
        }

        Rmax[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--){
            Rmax[i]=Integer.max(arr[i], Rmax[i+1]);
        }

        int i=0, j=0, maxDiff=-1;
        while(i<n && j<n){
            if(Lmin[i]<=Rmax[j]){
                maxDiff=Integer.max(maxDiff, j-i);
                j++;
            }else{
                i++;
            }
        }
        return maxDiff;
    }
}