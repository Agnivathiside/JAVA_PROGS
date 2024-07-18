
//{ Driver Code Starts
//Code by:Saksham Raj Seth
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class insert_in_sorted_circuler_LL_shit {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            insert_in_sorted_circuler_LL_shit llist = new insert_in_sorted_circuler_LL_shit();
            llist.head = null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            int value = sc.nextInt();
            Node phead = head;
            while (phead.next != null) {
                phead = phead.next;
            }
            phead.next = head;
            Solution ob = new Solution();
            head = ob.sortedInsert(head, value);
            Node current = head;

            if (head != null) {
                do {
                    System.out.print(current.data + " ");
                    current = current.next;
                } while (current != head);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

/*
 * Complete the function below
 * Node is as follows:
 * class Node{
 * int data;
 * Node next;
 * Node(int d){
 * data=d;
 * next=null;
 * }
 * }
 */
// 1 1 2 3 4 7 8 10
class Solution {
    static Node sortedInsert_mine(Node head1, int key) {
        // Add your code here.
        Node present = head1;
        Node future = head1.next;
        boolean flag = false;

        if (key < head1.data) {
            Node new_head = new Node(key);
            new_head.next = head1;
            return new_head;
        }
        if (key > head1.data && key < head1.next.data) {
            Node new_head = new Node(key);
            Node pre = head1;
            Node post = head1.next;
            new_head.next = post;
            pre.next = new_head;
            return head1;
        }

        while (future != null) {
            if ((key >= present.data) && (key <= future.data)) {
                Node node = new Node(key);
                node.next = future;
                present.next = node;
                flag = true;
                break;
            }
            future = future.next;
            present = present.next;
        }
        if (flag == false) {
            Node pre = head1;
            while (pre.next != null) {
                pre = pre.next;
            }
            Node node = new Node(key);
            pre.next = node;
        }
        return head1;
    }
    public static Node sortedInsert(Node head, int data) {
        // add code here.
        int start=head.data;
        Node h;
        if (head.data==head.next.data){
            h=head.next.next;
        }else{
            h=head;
        }

        while(h.next.data!=start){
            h=h.next;
        }
        h.next=null;
        Node node=sortedInsert_mine(head,data);
        Node h1=node;
        while (h1.next!=null){
            h1=h1.next;
        }
        h1.next=node;
        return node;
    }
}