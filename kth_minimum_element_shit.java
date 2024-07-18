import java.util.*;
public class kth_minimum_element_shit {
    public static int kth_minimum(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for (int i=k;i<arr.length;i++){
            if (pq.peek()>arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    // --> THIS CODE WILL WORK FINE BUT THIS WILL GIVE TLE
    // public static int kth_minimum(int arr[], int k){
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for (int i=0;i<arr.length;i++){
    //         pq.add(arr[i]);
    //     }
    //     System.out.println("Priority queue is: "+ pq);
    //     for (int i=0;i<k-1;i++){
    //         System.out.println("before poll: "+pq);
    //         pq.poll();
    //         System.out.println("after poll: "+pq);
    //     }
    //     System.out.println("finaly: "+pq);

    //     return pq.peek();
    // }
    public static void main(String[] args){
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter the value of K: ");
        int k= SC.nextInt();
        int[] array={20,10,60,30,50,40,70};
        System.out.print(kth_minimum(array, k));
        SC.close();
    }// 10 20 30 40 50 60
}
