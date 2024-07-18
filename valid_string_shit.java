// public class valid_string_shit

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class valid_string_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        Stack<Character> st = new Stack<>();
        int count= 0 ;
        st.add(S.charAt(0));

        for (int i=1; i<S.length(); i++){
            if (!st.isEmpty() && st.peek()=='(' && S.charAt(i)==')'){
                st.pop();
                count++;
            }else{
                st.add(S.charAt(i));
                count=0;
            }
        }
        return count*2;
    }
}