// public class sum_middle_two_sorted_arr_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sum_middle_two_sorted_arr_shit {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        ArrayList<Integer> arl = new ArrayList<>();
        int i=0, j=0;
        
        while (i<n && j<n){
            if (ar1[i]<ar2[j]){
                arl.add(ar1[i]);
                i++;
            }else{
                arl.add(ar2[j]);
                j++;
            }
        }
        
        while (i<n){
            arl.add(ar1[i]);
            i++;
        }
        while (j<n){
            arl.add(ar2[j]);
            j++;
        }

        System.out.println("The final array is "+arl);
        return arl.get(n-1)+arl.get(n);
    }
}
