// public class good_old_nokia_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class good_old_nokia_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();// testcases

        while (t-- > 0) {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; // input the elements of array that are keys to be pressed

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();// input the elements of array that are keys to be pressed
            ArrayList<String> res = new Solution().possibleWords(arr, n);
            for (String i : res)
                System.out.print(i + " ");
            System.out.println();

        }
    }
}

// } Driver Code Ends
/*"2": "abc",
"3": "def",
"4": "ghi",
"5": "jkl",
"6": "mno",
"7": "qprs",
"8": "tuv",
"9": "wxyz" */
// User function Template for Java

class Solution {
    // static void solve(int a[], int n, String str, int index, HashMap<Integer, String> map, ArrayList<String> arr){
    //     if (str.length()==a.length){
    //         arr.add(str);
    //         return;
    //     }
    //     String phoneStr=map.get(a[index]);
    //     for(int i=0; i<phoneStr.length(); i++){
    //         solve(a, n, str+phoneStr.charAt(i), index+1, map, arr);
    //     }
    // }
    static void solve(int a[], int n, String str, int index, HashMap<Integer, String> map, ArrayList<String> arr){
        if (index == n) { // Check if we have processed all digits
            arr.add(str.trim()); // Add the constructed word to the result list
            return;
        }
        
        // int digit = a[index]; // Get the digit at the current index
        String phoneStr = map.get(a[index]); // Get the corresponding letters for the digit
        
        // Iterate over each letter corresponding to the current digit
        for (int i = 0; i < phoneStr.length(); i++) {
            // char letter = phoneStr.charAt(i);
            // Recursively call solve with the updated string and index
            solve(a, n, str + phoneStr.charAt(i), index + 1, map, arr);
        }
    }    
    static ArrayList<String> possibleWords(int a[], int N) {
        // your code here
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "qprs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        ArrayList<String> arr = new ArrayList<>();
        String str = " ";
        solve(a, N, str, 0, map, arr);
        return arr;

    }
}
