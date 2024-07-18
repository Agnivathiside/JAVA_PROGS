//{ Driver Code Starts
    import java.util.*;

    class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d; 
            next = null;
        }
    }
    
    
    class MergeLists
    {
        Node head;
    
    
    
      /* Function to print linked list */
       public static void printList(Node head)
        {
            
            while (head!= null)
            {
               System.out.print(head.data+" ");
               head = head.next;
            }  
            System.out.println();
        }
        
         
     
         /* Driver program to test above functions */
        public static void main(String args[])
        {
           
             
            /* Constructed Linked List is 1->2->3->4->5->6->
               7->8->8->9->null */
             Scanner sc = new Scanner(System.in);
             int t=sc.nextInt();
             
             while(t>0)
             {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                Node head1 = new Node(sc.nextInt());
                Node tail1 = head1;
                for(int i=0; i<n1-1; i++)
                {
                    tail1.next = new Node(sc.nextInt());
                    tail1 = tail1.next;
                }
                Node head2 = new Node(sc.nextInt());
                Node tail2 = head2;
                for(int i=0; i<n2-1; i++)
                {
                    tail2.next = new Node(sc.nextInt());
                    tail2 = tail2.next;
                }
                
                LinkedList obj = new LinkedList();
                Node head = obj.sortedMerge(head1,head2);
                printList(head);
                
                t--;
                
             }
             sc.close();
        }
    }
    
    // } Driver Code Ends
    
    
    /*
      Merge two linked lists 
      head pointer input could be NULL as well for empty list
      Node is defined as 
        class Node
        {
            int data;
            Node next;
            Node(int d) {data = d; next = null; }
        }
    */
    
    class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
     Node curr1=head1;
            Node curr2=head2;
            Node newhead = new Node(0);
            Node dummy=newhead;
            while (curr1!=null && curr2!=null){
                if (curr1.data<curr2.data){
                    // I NEED NOT TO CREATE A DUMMY NODE EVERYTIME !
                    //Node temp=curr1;
                    //newhead.next=temp;
                    newhead.next=curr1;
                    //newhead=temp;
                    newhead=curr1;
                    curr1=curr1.next;
                }else{
                    //Node temp=curr2;
                    //newhead.next=temp;
                    newhead.next=curr2;
                    //newhead=temp;
                    newhead=curr2;
                    curr2=curr2.next;
                }
            }
            while (curr1!=null){
                //Node temp=curr1;
                //newhead.next=temp;
                //newhead=temp;
                //curr1=curr1.next;
                newhead.next=curr1;
                    //newhead=temp;
                    newhead=curr1;
                    curr1=curr1.next;
            }
            while (curr2!=null){
                //Node temp=curr2;
                //newhead.next=temp;
                //newhead=temp;
                //curr2=curr2.next;
                newhead.next=curr2;
                    //newhead=temp;
                    newhead=curr2;
                    curr2=curr2.next;
            }
            return dummy.next;
   } 
}
    