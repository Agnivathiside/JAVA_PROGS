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
    
    class Main {
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while (t-- > 0) {
                int n = sc.nextInt();
                
                int a = sc.nextInt();
                Node head = new Node(a);
                Node tail = head;
                
                for (int i=0; i<n-1; i++)
                {
                    a = sc.nextInt();
                    tail.next = new Node(a);
                    tail = tail.next;
                }
                
                int k = sc.nextInt();
                
                Solution ob = new Solution();
                head = ob.rotate(head,k);
                printList(head);
            }
            sc.close();
        }
        
        public static void printList(Node n) {
            while (n != null) {
                System.out.print(n.data + " ");
                n = n.next;
            }
            System.out.println();
        }
    }
    
    // } Driver Code Ends
    
    
    /* node of linked list:
    
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    
    */
    
    class Solution{
        //Function to rotate a linked list.
        public Node rotate(Node head, int k) {
            // add code here
            Node curr1=head;
            Node curr2=head;
            //4
            //1, 2, 3, 4, 5, 6, 7, 8, 1
            while (curr1.next!=null){
                curr1=curr1.next;
            }
            curr1.next=head;
            for (int i=0;i<k-1;i++){
                curr2=curr2.next;
            }
            Node newhead= new Node(1);
            newhead.next=curr2.next;
            curr2.next=null;
            return newhead.next;
        }
    }
    