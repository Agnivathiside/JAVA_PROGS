//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class add_nums_LL_shit {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends

/*
 * node for linked list
 * 
 * class Node {
 * int data;
 * Node next;
 * 
 * Node(int d) {
 * data = d;
 * next = null;
 * }
 * }
 * 
 */

class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        // code here
        // return head of sum list
        String num1="";
        String num2="";

        Node cur1=first;
        Node cur2=second;

        while (cur1!=null){
            num1+=String.valueOf(cur1.data);
        }

        while (cur2!=null){
            num2+=String.valueOf(cur2.data);
        }

        int final_num=Integer.valueOf(num1)+Integer.valueOf(num2);
        String num_final=String.valueOf(final_num);

        Node dummy= new Node(-1);
        Node head=dummy;

        for(int i=0;i<num_final.length();i++){
            Node cur=new Node(Integer.valueOf(num_final.charAt(i)));
            dummy.next=cur;
            dummy=dummy.next;
        }
        return head.next;
    }
}