public class kadans_algo_shit {
    public static int maxSum(int arr[]){
        int current_sum=0;
        int max_sum=0;
        for (int i=0;i<arr.length;i++){
            current_sum=current_sum+arr[i];
            if (current_sum>max_sum){
                max_sum=current_sum;
            }
            if (current_sum<0){
                current_sum=0;
            }
        }
        return max_sum;
    }
    public static void main(String[] args){
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(a));
    }
}
