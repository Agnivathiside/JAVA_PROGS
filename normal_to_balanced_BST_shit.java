// public class normal_to_balanced_BST_shit

//{ Driver Code Starts
import java.util.*;
import java.util.LinkedList;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node right, left;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class normal_to_balanced_BST_shit{
    static Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

    }

    int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            GfG gfg = new GfG();

            root = gfg.buildBalancedTree(root);
            // preOrder(root);
            normal_to_balanced_BST_shit bst = new normal_to_balanced_BST_shit();
            System.out.println(bst.height(root));
            t--;
        }
    }

    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

// } Driver Code Ends

/*
 * class Node
 * {
 * int data;
 * Node right, left;
 * Node(int item)
 * {
 * data = item;
 * left = right = null;
 * }
 * }
 */

class GfG {
    void inorder(Node root, ArrayList<Node> arl) {
        if (root == null)
            return;

        inorder(root.left, arl);
        arl.add(root);
        inorder(root.right, arl);
    }

    Node makeBST(ArrayList<Node> arl, int start, int end) {
        if (start>end) return null;
        int mid = start + (end - start) / 2;

        arl.get(mid).left = makeBST(arl, start, mid - 1);
        arl.get(mid).right = makeBST(arl, mid + 1, end);

        return arl.get(mid);

    }

    Node buildBalancedTree(Node root) {
        // Add your code here.
        ArrayList<Node> arl = new ArrayList<>();
        inorder(root, arl);
        return makeBST(arl, 0, arl.size() - 1);
    }
}
