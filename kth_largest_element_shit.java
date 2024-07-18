import java.util.*;
public class kth_largest_element_shit {
    public static int kth_largest(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for (int i=k;i<arr.length;i++){
            if (pq.peek()<arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    public static int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[k];
        for (int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for (int i=k; i<n;i++){
            if (arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        for (int i=k-1;i>=0;i--){
            ans[i]=pq.poll();
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.print("Enter the value of K: ");
        int k=SC.nextInt();
        int[] array={1, 23, 12, 9, 30, 2, 50};
        // System.out.print(kLargest(array,array.length,k));
        int [] ans = kLargest(array, array.length, k);
        for (int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        SC.close();
    }
}
