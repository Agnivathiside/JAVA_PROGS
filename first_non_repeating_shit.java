// public class first_non_repeating_shit

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class first_non_repeating_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends

class Solution {
    public String FirstNonRepeating(String A) {
        // code here
        // aaabccbdca
        Stack<Character> st = new Stack<>();
        int str_len=A.length();
        char last=' ';
        for(int i=0; i<str_len; i++){
            // last=A.charAt(i);
            if (st.isEmpty()){
                st.add(A.charAt(i));
            }
            else if (last==A.charAt(i)){
                st.add('#');
            }else{
                last=A.charAt(i);
                st.add(A.charAt(i));
            }
        }
        String ans = "";
        while (!st.isEmpty()) {
            ans=st.pop()+ans;
            System.out.println("String update "+ans);
        }
        System.out.println("String is "+ans);
        return ans;
    }
}