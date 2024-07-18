// public class stock_buy_sell_shit {
//     public static int max_position(int arr[]){
//         int max_element=0;
//         int max_pos=0;
//         for (int i=0;i<arr.length;i++){
//             if (arr[i]>max_element){
//                 max_element=arr[i];
//                 max_pos=i;
//             }
//         }
//         return max_pos;
//     }
//     public static int maxProfit(int arr[]){
//         int upper_bound=max_position(arr);
//         int min=99999999;
//         for (int i=0;i<=upper_bound;i++){
//             if (arr[i]<min){
//                 min=arr[i];
//             }
//         }
//         return (arr[upper_bound]-min);
//     }
//     public static void main(String[] args){
//         int stock[]={3,5,9,7,4,1,3};
//         System.out.println(maxProfit(stock));
//     }
    
// }

// NOW LET'S MAKE THIS CODE BETTER !!
public class stock_buy_sell_shit {
    public static int maxProfit(int arr[]){
        int min_so_far=arr[0];
        int max_so_far=0;
        for (int i=0;i<arr.length;i++){
            min_so_far=Math.min(min_so_far, arr[i]);
            int profit=arr[i]-min_so_far;
            max_so_far=Math.max(profit, max_so_far);
        }
        return max_so_far;
    }
    public static void main(String[] args){
        int stock[]={7,1,5,3,6,4};
        System.out.println(maxProfit(stock));
    }
}
