// public class print_bracket_number_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class print_bracket_number_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> arl = new ArrayList<>();
        int x=0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if (str.charAt(i)=='('){
                x++;
                arl.add(x);
                st.add(str.charAt(i));
            }else if (str.charAt(i)==')' && st.peek()=='('){
                arl.add(x);
                st.add(str.charAt(i));
            }else if (str.charAt(i)==')' && st.peek()==')'){
                arl.add(x-1);
                st.add(str.charAt(i));
            }else{
                continue;
            }
        }
        return arl;
    }
};
