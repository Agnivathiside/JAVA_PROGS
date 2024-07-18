// public class equi_point_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class equi_point_shit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();

            // calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends

class Solution {

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        if (arr.length==1) return 1;

        int sum=0;
        for (int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        int left_sum=0;
        for (int i=0; i<arr.length; i++){
            if (left_sum==sum-arr[i]){
                return i+1;
            }
            left_sum+=arr[i];
            sum-=arr[i];
        }
        return -1;
    }
}
