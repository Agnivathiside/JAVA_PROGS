// public class jump_game_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class jump_game_shit{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S1[] = read.readLine().split(" ");

            int[] A = new int[N];

            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A, N));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// class Solution {
//     static boolean solve(int A[], int n, int index){
//         if (index>=n){
//             return true;
//         }
//         if (A[index]==0){
//             return false;
//         }
//         boolean ans = true;
//         for(int i=index+1; i<A[index]+index; i++){
//             ans = solve(A, n, i);
//             if (ans == true){
//                 return true;
//             }
//         }
//         return ans;
//     }
//     static int canReach(int[] A, int N) {
//         // code here
//         boolean res = solve(A, N, 0);
//         return res==true?1:-1;
//     }
// }
class Solution {
    static boolean solve(int A[], int n, int index){
        if (index >= n - 1) {
            return true;
        }
        if (A[index] == 0) {
            return false;
        }
        for (int i = 1; i <= A[index]; i++) {
            if (solve(A, n, index + i)) {
                return true;
            }
        }
        return false;
    }
    
    static int canReach(int[] A, int N) {
        // code here
        boolean res = solve(A, N, 0);
        return res ? 1 : -1;
    }
}
