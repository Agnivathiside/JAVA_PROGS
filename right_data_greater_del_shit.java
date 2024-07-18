
//{ Driver Code Starts
import java.util.*;

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class right_data_greater_del_shit {

    /* Function to print linked list */
    public static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {

        /*
         * Constructed Linked List is 1.2.3.4.5.6.
         * 7.8.8.9.null
         */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt()) {
            int n = sc.nextInt();

            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt(); i++) {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends

/*
 * class Node {
 * int data;
 * Node next;
 * 
 * Node(int data) {
 * this.data = data;
 * }
 * }
 */
// 12->15->10->11->5->6->2->3
// 10->20->30->40->50->60
class Solution {
    Node compute(Node head) {
        // your code here
        // Stack<Integer> st1=new Stack<>();
        // Stack<Integer> st2=new Stack<>();
        // Node present=head.next;
        // st1.add(head.data);
        // while (present!=null){
        //     if (present.data>st1.peek()){
        //         st1.pop();
        //         st1.add(present.data);
        //     }
        //     st1.add(present.data);
        //     present=present.next;
        // }
        // while (!st1.empty()){
        //     st2.add(st1.pop());
        // }
        // Node dummy=new Node(-1);
        // Node h1=dummy;
        // System.out.println(st2);
        // while (!st2.empty()){
        //     Node node=new Node(st2.peek());
        //     h1.next=node;
        //     h1=h1.next;
        // }

        // return dummy.next;
        Stack<Node> S = new Stack<>();
        S.add(head);
        Node p = head.next;
        while (p != null) {
            while (!S.empty() && S.peek().data < p.data) S.pop();
            S.add(p);
            p = p.next;
        }
        Node pre = new Node(0);
        while (!S.empty()) {
            Node q = S.pop();
            q.next = pre.next;
            pre.next = q;
       }
       return pre.next;
    }
}
