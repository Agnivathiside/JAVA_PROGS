// public class minimum_jump_shit

//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;

public class minimum_jump_shit {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String) br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
    }

}

// } Driver Code Ends

class Solution {
    static void solve(int arr[], int index, int count) {
        if (index > arr.length)
            return;

        if (arr[index] >= arr.length - 1 - index && arr[arr.length - 1] != 0) {
            count+=1;
        }

        for (int i = index + 1; i < arr[index] + 1; i++) {
            solve(arr, i, count);
        }
    }

    static int minJumps(int[] arr) {
        // your code here
        int count = 0;
        solve(arr, 0, count);
        return count;
    }
}
