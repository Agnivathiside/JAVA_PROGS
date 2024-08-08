// public class flatten_BST_sorted_list_shit

//{ Driver Code Starts
import java.util.*;
import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class flatten_BST_sorted_list_shit
{
    public static void printList(Node head) {
        while (head != null) {
            if (head.left != null)
                System.out.print("-1 ");
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String str = sc.nextLine();
            Node root = buildTree(str);
            Solution ob = new Solution();
            Node ans = ob.flattenBST(root);
            printList(ans);
        }
        sc.close();
    }

    private static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] ip = str.split("\\s+");
        int index = 0;

        Node root = new Node(Integer.parseInt(ip[index++]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && index < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            if (index >= ip.length)
                break;
            currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
        }

        return root;
    }
}

// } Driver Code Ends



class Solution {
    void inorder(Node root, ArrayList<Integer> arl){
        if (root == null){
            return;
        }
        
        inorder(root.left, arl);
        arl.add(root.data);
        inorder(root.right, arl);
    }
    public Node flattenBST(Node root) {
        // Code here
        ArrayList<Integer> arl = new ArrayList<>();
        inorder(root, arl);
        Node dummy = new Node(-1);
        Node newRoot = dummy;
        for(int i=0; i<arl.size(); i++){
            newRoot.right = new Node(arl.get(i));
            newRoot = newRoot.right;
        }
        return dummy.right;
    }
}