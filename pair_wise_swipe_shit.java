
//{ Driver Code Starts
import java.util.*;

import javax.print.attribute.standard.RequestingUserName;

import java.io.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

class pair_wise_swipe_shit {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data);
            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data);
            }

            Node failure = new Node(-1);

            Solution g = new Solution();
            head = g.pairwiseSwap(head);

            Node temp = head;
            int f = 0;
            while (temp != null) {
                if (mp.get(temp) != temp.data) {
                    f = 1;
                }
                temp = temp.next;
            }

            if (f == 1) {
                printList(failure);
            } else {
                printList(head);
            }
            t--;
        }
    }
}

// } Driver Code Ends

/*
 * node class of the linked list
 * 
 * class Node
 * {
 * int data;
 * Node next;
 * Node(int key)
 * {
 * data = key;
 * next = null;
 * }
 * }
 * 
 */

class Solution {
    // public Node solve(Node head){
    //     if (head==null || head.next==null) return head;
    //     // Node temp1=head;
    //     // Node temp2=head.next;
    //     // temp2.next=temp1;
    //     // temp1.next=solve(head.next.next);
        
    //     // return temp2;
    //     Node remainig=solve(head.next.next);
    //     Node second=head.next;
    //     head.next=remainig;
    //     second.next=head;
    //     return second;
    // }
    public Node pairwiseSwap(Node head) {
        if (head==null || head.next==null) return head;
        // Node temp1=head;
        // Node temp2=head.next;
        // temp2.next=temp1;
        // temp1.next=solve(head.next.next);
        
        // return temp2;
        Node remainig=pairwiseSwap(head.next.next);
        Node second=head.next;
        head.next=remainig;
        second.next=head;
        return second;
    }
}