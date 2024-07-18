public class binary_search_shit {
    public static void main(String[] args){
        int[] nums={3,12,18,28,29,30,35,36,40,45};
        int target=3;

        int start=0;
        int end=nums.length-1;
        int mid=start+(end-start)/2;

        while (end>=start){
            if (target==nums[mid]){
                System.out.println("Index is "+mid);
                break;
            }else if (target>nums[mid]){
                start=mid+1;
            }else {
                end=mid-1;
            }
            mid=start+(end-start)/2;
        }
        System.out.println("paini bara ei ne "+ -1);

    }
}
