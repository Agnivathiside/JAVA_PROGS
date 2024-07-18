// public class maximum_path_sum_shit

//{ Driver Code Starts
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

public class maximum_path_sum_shit {

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

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution tr = new Solution();
            int sum = tr.findMaxSum(root);
            System.out.println(sum);
        }
    }
}
// } Driver Code Ends

/*
 * Node defined as
 * class Node{
 * int data;
 * Node left,right;
 * Node(int d){
 * data=d;
 * left=right=null;
 * }
 * }
 */

// class Solution {
//     int maxi=Integer.MIN_VALUE;
//     int solve(Node node){
//         if (node==null) return 0;

//         int left = node.data + solve(node.left);
//         int right = node.data +  solve(node.right);
//         int both = node.data + solve(node.left) + solve(node.right);

//         maxi=Math.max(left, Math.max(maxi, Math.max(right, both)));
//         return maxi;

//     }
//     int findMaxSum(Node node){
//         // your code goes here
//         return solve(node);

//     }
// }
class Solution {
    int maxi = Integer.MIN_VALUE;

    int solve(Node node) {
        if (node == null)
            return 0;

        // Calculate the sum of the left subtree
        int left = Math.max(0, solve(node.left));

        // Calculate the sum of the right subtree
        int right = Math.max(0, solve(node.right));

        // Update the maximum sum by considering the current node and its subtrees
        maxi = Math.max(maxi, node.data + left + right);

        // Return the maximum sum possible considering the current node
        return node.data + Math.max(left, right);
    }

    int findMaxSum(Node node) {
        // Call the recursive function to find the maximum sum
        solve(node);

        // Return the maximum sum found
        return maxi;
    }
}
