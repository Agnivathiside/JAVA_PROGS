// public class remove_alternative_kth_nodes_shit

//{ Driver Code Starts
import java.util.*;

class Node {
    Node next;
    int data;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class remove_alternative_kth_nodes_shit {
    Node head;
    Node tail;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            remove_alternative_kth_nodes_shit list = new remove_alternative_kth_nodes_shit();
            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                list.addToTheLast(new Node(a));
            }
            int k = sc.nextInt();
            // System.out.println(list.head.data+" "+ k);
            list.head = new Solution().delete(list.head, k);
            Node temp = list.head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends

/*
 * Link list Node
 * class Node
 * {
 * Node next;
 * int data;
 * Node(int d)
 * {
 * data = d;
 * next = null;
 * }
 * }
 */
// class Solution {
//     /* You are required to complete this method */
//     Node delete(Node head, int k) {
//         // Your code here
//         if (k==1) return null;
//         Node curr = head;
//         int n=1;
//         while (curr!=null) {
//             if ((n+1)%k ==0){
//                 curr = curr.next.next;
//                 k=k+2;
//             }else{
//                 curr = curr.next;
//                 k++;
//             }
//         }
//         return head;
//     }
// }
class Solution {
    /* You are required to complete this method */
    Node delete(Node head, int k) {
        // Your code here
        ArrayList<Integer> arl = new ArrayList<>();
        Node curr = head;
        while (curr!=null){
            arl.add(curr.data);
            curr=curr.next;
        }
        Node dummy = new Node(-1);
        Node curr1 = dummy;
        for (int i=0; i<arl.size(); i++){
            if (i%k==0){
                continue;
            }else{
                Node temp = new Node(arl.get(i));
                curr1.next = temp;
                curr1 = curr1.next;
            }
        }
        return dummy.next;
    }
}