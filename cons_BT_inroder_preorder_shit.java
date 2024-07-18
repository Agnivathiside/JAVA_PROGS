//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class cons_BT_inroder_preorder_shit
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution{
    public static int findPosition(HashMap<Integer, Integer> map, int element){
        // for (int i=0;i<size;i++){
        //     if(inorder[i]==element){
        //         return i;
        //     }
        // }
        // return -1;
        return map.get(element);
    }
    public static Node solve(int inorder[], int preorder[], int preOrderIndex, int inorderStartIndex, int inorderEndIndex, int n,HashMap<Integer, Integer> map){

        if((preOrderIndex>=n) || (inorderStartIndex>inorderEndIndex)){
            return null;
        }

        int element=preorder[preOrderIndex];
        Node root=new Node(element);
        int position=findPosition(map,element);

        root.left=solve(inorder, preorder, preOrderIndex+1, inorderStartIndex, position-1, n,map);
        root.right=solve(inorder, preorder, preOrderIndex+1, position+1, inorderEndIndex, n,map);

        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n){

        int preOrderIndex=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(preorder[i],i);
        }
        Node node=solve(inorder, preorder, preOrderIndex, 0, n-1, n, map);
        return node;

    }
}
