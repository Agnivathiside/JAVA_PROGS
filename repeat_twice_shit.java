// public class repeat_twice_shit

//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

public class repeat_twice_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String l = br.readLine();
            String[] sarr = l.split(" ");
            int[] arr = new int[sarr.length];
            for (int i1 = 0; i1 < arr.length; i1++) {
                arr[i1] = Integer.parseInt(sarr[i1]);
            }

            Solution obj = new Solution();

            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

// User function template for JAVA

class Solution {
    // Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        int ans[] = new int[2];
        int i=0;
        for (int keys: map.keySet()){
            if (map.get(keys)==2){
                ans[i]=keys;
                i++;
            }
        }
        return ans;
    }

}
