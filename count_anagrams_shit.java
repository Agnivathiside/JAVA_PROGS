// public class count_anagrams_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class count_anagrams_shit {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    boolean isAnagramn(HashMap<Character, Integer> map1, String str2){
        
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i=0; i<str2.length(); i++){
            map2.put(str2.charAt(i), 1+ map2.getOrDefault(str2.charAt(i), 0));
        }

        if (map1.size()==map2.size()){
            for (Character ch :map1.keySet()){
                if (!map2.containsKey(ch) || map2.get(ch)!=map1.get(ch)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    int search(String pat, String txt) {
        // code here
        int count=0;
        int left=0, right=pat.length();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int i=0; i<pat.length(); i++){
            map1.put(pat.charAt(i), 1+ map1.getOrDefault(pat.charAt(i), 0));
        }

        while(right<=txt.length()){
            // System.out.println("Now checking for index "+left+ " and "+(right-1));
            if (isAnagramn(map1, txt.substring(left, right))){
                // System.out.println("Anagram is "+txt.substring(left, right));
                count++;
            }
            left++;
            right++;
        }
        return count;
    }
}