// public class max_width_BT_shit

//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

public class max_width_BT_shit {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            int res = g.getMaxWidth(root);
            System.out.println(res);
            // CLN.inorder(root);
            t--;
            // System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // int sum(ArrayList<Integer> arl){
    //     int ans = 0;
    //     for(int i:arl){
    //         ans+=i;
    //     }
    //     return ans;
    // }
    int getMaxWidth(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> LOT = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            ans = Math.max(ans, levelSize);
            ArrayList<Integer> arl = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                // if (q.peek().data !=-1 && q.peek().left==null){
                //     Node temp = new Node(-1);
                //     q.offer(temp);
                // }else if (q.peek().data !=-1){
                //     q.offer(q.peek().left);
                // }
                // if (q.peek().data !=-1 && q.peek().right == null){
                //     Node temp = new Node(-1);
                //     q.offer(temp);
                // }else if (q.peek().data !=-1){
                //     q.offer(q.peek().right);
                // }
                if (q.peek().left!=null) q.offer(q.peek().left);
                if (q.peek().right!=null) q.offer(q.peek().right);
                arl.add(q.poll().data);
            }
            LOT.add(arl);
        }
        // System.out.println("LEVEL ORDER TRAVERSAL IS "+LOT);
        // int ans = Integer.MIN_VALUE;
        // for(int i=0; i<LOT.size(); i++){
        //     if (sum(LOT.get(i))!=-LOT.get(i).size()){
        //         ans = Math.max(ans, LOT.get(i).size());
        //     }
        // }
        return ans;
    }
}










