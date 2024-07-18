// public class vertical_width_BT_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

public class vertical_width_BT_shit {

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
            Solution obj = new Solution();
            int ans = obj.verticalWidth(root);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    int left = 0;
    int right = 0;
    public void findRightMost(Node root, int currRight){
        if (root==null){
            return;
        }
        if (currRight>right){
            right = currRight;
        }
        findRightMost(root.right, currRight+1);
        findRightMost(root.left, currRight-1);
    }
    public void findLeftMost(Node root, int currLeft){
        if (root==null){
            return;
        }
        if (currLeft<left){
            left = currLeft;
        }
        findLeftMost(root.left, currLeft-1);
        findLeftMost(root.right, currLeft+1);
    }
    public int verticalWidth(Node root) {
        // code here.
        if (root == null) return 0;

        findLeftMost(root, 0);
        findRightMost(root, 0);

        // System.out.println("Left value is "+ left);
        // System.out.println("Right value is "+ right);
        
        return right-left+1;
    }
}
