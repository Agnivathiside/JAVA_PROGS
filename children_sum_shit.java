// public class children_sum_shit

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Contributed by Sudarshan Sharma
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

public class children_sum_shit {

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
            if (i >= ip.length)
                break;

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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.isSumProperty(root));

        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Complete the function below
 * Node is as follows:
 * class Node{
 * int data;
 * Node left,right;
 * 
 * Node(int key)
 * {
 * data = key;
 * left = right = null;
 * }
 * }
 * 
 */
class Solution {
    public static int solve(Node root){
        if (root==null) return 1;
        if (root.left==null && root.right==null) return 1;

        boolean yes = false;
        int left=0, right=0;
        if (root.left==null){
            left=0;
        }else{
            left=root.left.data;
        }
        if (root.right==null){
            right=0;
        }else{
            right=root.right.data;
        }

        yes = root.data==(left+right);
        if (yes){
            int seeRight = solve(root.right);
            int seeLeft = solve(root.left);
            if (seeRight!=1 || seeLeft!=1) return 0;
        }else{
            return 0;
        }
        return 1;
        
    }
    public static int isSumProperty(Node root) {
        // add your code here
        return solve(root);

    }
}
