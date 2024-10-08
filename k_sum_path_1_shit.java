//public class k_sum_path_1_shit
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class k_sum_path_1_shit {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        // Queue <Node> q = new LinkedList<Node>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();

            System.out.println(ob.sumK(root, k));
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

// class Solution {
//     public void sum(Node root, int k,ArrayList<Integer> arl, int count){
//         if (root==null) return;

//         arl.add(root.data);

//         sum(root.left, k, arl, count);
//         sum(root.right, k, arl, count);

//         int size=arl.size();
//         int sum=0;
//         for (int i=size-1;i>=0;i--){
//             sum+=arl.get(i);
//             if (sum==k){
//                 count++;
//             }
//         }
//         arl.remove(arl.get(size-1));
//     }
//     public int sumK(Node root, int k) {
//         // code here
//         ArrayList<Integer> arl = new ArrayList<>();
//         int count = 0;
//         sum(root, k, arl, count);
//         return count;
//     }
// }



//User function Template for Java

class Solution
{
    int count = 0;
    void helper(Node root,int k,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        int size = path.size();
        int sum = 0;
        for(int i=size-1;i >=0;i--){
            sum += path.get(i);
            if(sum == k){
                count++;
            }
        }
        helper(root.left,k,path);
        helper(root.right,k,path);
        path.remove(path.size()-1);
    }
    public int sumK(Node root,int k)
    {
        // code here 
        ArrayList<Integer> path = new ArrayList<>();
        helper(root , k, path);
        return count;
    }
}