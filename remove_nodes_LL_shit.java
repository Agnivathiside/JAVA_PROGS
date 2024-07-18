import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;;
/**
 * Definition for singly-linked list.
 * 
 */

public class remove_nodes_LL_shit {
    public class ListNode {
        int val;
        ListNode next;
    
        ListNode() {
        }
    
        ListNode(int val) {
            this.val = val;
        }
    
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // public ListNode revList(ListNode head){
    //     if (head!=null || head.next!=null){
    //         return head;
    //     }

    //     ListNode rev = revList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return rev;
    // }
    // public ListNode removeNodes(ListNode head) {
    //     // Queue<Integer> q = new LinkedList<>();
    //     Stack<Integer> st = new Stack<>();
    //     ListNode curr = head.next;
    //     // q.offer(head.val);
    //     st.add(curr.val);
    //     while (curr!=null){
    //         while (!st.isEmpty() && curr.val>st.peek()){
    //             st.pop();
    //         }
    //         st.add(curr.val);
    //         curr = curr.next;
    //     }

    //     ListNode dummy = new ListNode(-1);
    //     ListNode newHead = dummy;
    //     while (!st.isEmpty()){
    //         ListNode temp = new ListNode(st.pop());
    //         newHead.next = temp;
    //         newHead = newHead.next;
    //     }
    //     return revList(dummy.next);
    // }
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}
