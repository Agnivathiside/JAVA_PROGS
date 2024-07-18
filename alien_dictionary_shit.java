// public class alien_dictionary_shit

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

public class alien_dictionary_shit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            // System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++)
                temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {

                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0; i < Math.min(a.length(), b.length())
                            && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;

                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }

}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> arl, boolean vis[]){
        vis[node] = true;
        for(int i:arl.get(node)){
            if (!vis[i]){
                dfs(i, st, arl, vis);
            }
        }
        st.add(node);
    }
    public ArrayList<Integer> topoSort(int n, ArrayList<ArrayList<Integer>> arl){
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            vis[i] = false;
        }
        for(int i=0; i<n; i++){
            if (!vis[i]){
                dfs(i, st, arl, vis);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!st.isEmpty()){
            topo.add(st.pop());
        }
        return topo;
    }
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        ArrayList<ArrayList<Integer>> arl = new ArrayList<>();
        for(int i=0; i<K; i++){
            arl.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());
            for(int ptr=0; ptr<len; ptr++){
                if (s1.charAt(ptr)!=s2.charAt(ptr)){
                    arl.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }

        ArrayList<Integer> lis = topoSort(K, arl);
        String ans = "";
        for(int i:lis){
            ans = ans + (char)(i + (int)'a');
        }

        return ans;

    }
}