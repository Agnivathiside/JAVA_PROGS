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

class add_two_num_LL_shit{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
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
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
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


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    // static Node addTwoLists(Node first, Node second){
    //     // code here
    //     // return head of sum list
    //     String ll1="";
    //     String ll2="";
    //     Node curr1=first;
    //     Node curr2=second;
    //     while(curr1!=null){
    //         ll1+=String.valueOf(curr1.data);
    //         curr1=curr1.next;
    //     }
    //     while(curr2!=null){
    //         ll2+=String.valueOf(curr2.data);
    //         curr2=curr2.next;
    //     }
    //     //int num1=Integer.parseInt(ll1);
    //     long num1=Long.parseLong(ll1);
    //     //int num2=Integer.parseInt(ll2);
    //     long num2=Long.parseLong(ll2);
    //     long res=num1+num2;
    //     String res_str=String.valueOf(res);
    //     Node dummy1=new Node(-1);
    //     Node dummy2=dummy1;
    //     for (int i=0;i<res_str.length();i++){
    //         Node num=new Node(Integer.parseInt(String.valueOf(res_str.charAt(i))));
    //         dummy1.next=num;
    //         dummy1=num;
    //     }
    //     return dummy2.next;
    // }
    static void insertAtTail(Node head, Node tail, int val){
        Node temp = new Node(val);
        if (head==null){
            head=temp;
            tail=temp;
            return;
        }else{
            tail.next=temp;
            tail=temp;
        }
    }
    static Node reverse(Node head){
        if (head==null){
            return head;
        }
        Node r=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return r;
    }
    static Node add(Node head1, Node head2){
        Node anshead=null;
        Node anstail=null;
        int carry=0;
        while (head1!=null && head2!=null){
            int sum=carry+head1.data+head2.data;
            int digit=sum%10;
            insertAtTail(anshead,anstail,digit);
            carry=sum/10;
            head1=head1.next;
            head2=head2.next;
        }
        
        while (head1!=null){
            int sum=carry+head1.data;
            int digit=sum%10;
            insertAtTail(anshead, anstail, digit);
            carry=sum/10;
            head1=head1.next;
        }
        while (head2!=null){
            int sum=carry+head2.data;
            int digit=sum%10;
            insertAtTail(anshead, anstail, digit);
            carry=sum/10;
            head2=head2.next;
        }
        while (carry!=0){
            int sum=carry;
            int digit=sum%10;
            insertAtTail(anshead, anstail, digit);
            carry=carry/10;
        }
        return anshead;
        

    }
    static Node addTwoLists(Node first, Node second){
        // Step 1- Reverse the given LL
        // Step 2- Add the LLs
        // Step 3- Reverse the resulting LL
        first=reverse(first);
        second=reverse(second);

        Node ans=add(first,second);
        ans =reverse(ans);
        return ans;

    }
}