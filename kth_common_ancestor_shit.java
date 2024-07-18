// public class kth_common_ancestor_shit

//{ Driver Code Starts
import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class kth_common_ancestor_shit {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
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

                // Create the right child for the curr node
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
            String s = br.readLine().trim();
            Node root = buildTree(s);

            String[] snums = br.readLine().split(" ");
            int k = Integer.parseInt(snums[0]);
            int x = Integer.parseInt(snums[1]);
            int y = Integer.parseInt(snums[2]);

            Solution T = new Solution();
            // Call the function with the needed parameters
            System.out.println(T.kthCommonAncestor(root, k, x, y));

            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    public Node lca (Node root, int x, int y){
        if (root == null) return null;

        if (root.data<x && root.data<y) return lca(root.right, x, y);
        if (root.data>x && root.data>y) return lca(root.left, x, y);
        return root;
    }
    // public void findPathAndSave(Node root, ArrayList<Integer> arl, Node target){
    //     if (root == null) return;
    //     if (root.data == target.data) {
    //         arl.add(root.data);
    //         return;
    //     }

    //     arl.add(root.data);
    //     findPathAndSave(root.left, arl, target);
    //     findPathAndSave(root.right, arl, target);
    //     arl.remove(arl.size()-1);
    // }
    public void findPathAndSave(Node root, ArrayList<Integer> arl, Node target) {
        if (root == null) return;
        
        // Add the current node to the path
        arl.add(root.data);
        
        // If the current node is the target, return
        if (root.data == target.data) {
            return;
        }
        
        // Check in the left subtree
        findPathAndSave(root.left, arl, target);
        
        // If target is found in the left subtree, return
        if (!arl.isEmpty() && arl.get(arl.size() - 1) == target.data) {
            return;
        }
        
        // Check in the right subtree
        findPathAndSave(root.right, arl, target);
        
        // If target is found in the right subtree, return
        if (!arl.isEmpty() && arl.get(arl.size() - 1) == target.data) {
            return;
        }
        
        // If target is not found in either subtree, backtrack
        arl.remove(arl.size() - 1);
    }    
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        Node baap = lca (root, x, y);

        // find the path from root to baap and save it in an arayList
        ArrayList<Integer> arl = new ArrayList<>();
        findPathAndSave(root, arl, baap);
        if (k>arl.size()) return -1;
        Collections.reverse(arl);
        return arl.get(k-1);
    }
}
