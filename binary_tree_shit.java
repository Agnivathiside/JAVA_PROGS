import java.util.*;
import java.util.LinkedList;

import javax.management.Query;
class node{
    int data;
    node left;
    node right;

    node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class binary_tree_shit {

    public static node buildTree(node root){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the data: ");
        int num= sc.nextInt();

        root=new node(num);

        if (num==-1){
            return null;
        }

        System.out.print("Enter data for the left node of "+num);
        root.left=buildTree(root.left);
        System.out.print("Enter data for the right node of "+num);
        root.right=buildTree(root.right);

        return root;
    }

    static void levelOrderTraversal(node root){
        Queue<node> q= new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            node top = q.peek();
            q.poll();
            if (top==null){
                System.out.println("/n");
                if (!q.isEmpty()){
                    q.add(null);
                }
            }else{
                System.out.println(top.data);
                if (top.left!=null){
                    q.add(top.left);
                }
                if (top.right!=null){
                    q.add(top.right);
                }
            }
        }
    }
    static void inOrderTraversal(node root){ // L(Left) N(Node) R(Right)
        if (root==null) return;

        inOrderTraversal(root.left);
        System.out.println(root.data+ "");
        inOrderTraversal(root.right);
    }
    static void preOrderTraversal(node root){
        if (root == null) return;

        System.out.println(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    static void postOrderTraversal(node root){
        if (root==null) return;

        System.out.println(root.data+ " ");
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
    }
    public static void main(String[] args){
        node root=null;
        root=buildTree(root);
        // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        System.out.println("Level order traversal is ");
        levelOrderTraversal(root);

        System.out.println("Inorder traversal is : ");
        inOrderTraversal(root);

        System.out.println("Pre order traversal is ");
        preOrderTraversal(root);

        System.out.println("Poat order traversal is ");
        postOrderTraversal(root);
    }    
}
