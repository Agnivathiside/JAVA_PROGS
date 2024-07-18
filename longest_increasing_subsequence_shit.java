// public class longest_increasing_subsequence_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class longest_increasing_subsequence_shit {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    static int solve(int i, int arr[], int n){
        System.out.println("Now index is "+i);
        // if (i>n) return 0;
        if (i==n-1) return 1;
        System.out.println("current element is "+arr[i]);
        int include=Integer.MIN_VALUE;
        int exclude=Integer.MIN_VALUE;
        if(arr[i+1]>arr[i]){
            include = 1+solve(i+1, arr, n);
            exclude = 1+solve(i+2, arr, n);
        }else{
            i++;
        }
        return Math.max(include, exclude);
    }
    static int longestSubsequence(int size, int a[]) {
        // code here
        int max=Integer.MIN_VALUE;
        for (int i=0; i<size; i++){
            max=Math.max(max, solve(i, a, size-1));
        }
        return max;

    }
}
