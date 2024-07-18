// public class len_long_subarr_shit

import java.util.HashMap;
import java.util.HashSet;

public class len_long_subarr_shit {
    public boolean windowContainsAllElements(HashSet<Integer> set, int i, int j, int nums[]){
        if (set.size()!=j-i+1){
            return false;
        }else{
            for(int x=i; x<=j; x++){
                if (!set.contains(nums[x])){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean freq(HashMap<Integer, Integer> map, int k){
        for (int keys:map.keySet()){
            if (map.get(keys)!=k){
                return false;
            }
        }
        return true;
    }
    public int maxSubarrayLength(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0, j=0;
        int maxLen=Integer.MIN_VALUE;
        while (j<nums.length){
            if (windowContainsAllElements(set, i, j, nums) && (freq(map, k))){
                maxLen = Math.max(maxLen, j-i+1);
                i++;
                j=i;
            }else{
                if (map.containsKey(nums[j])){
                    map.put(nums[j], map.get(nums[j])+1);
                }else{
                    map.put(nums[j], 1);
                }
                j++;
            }
        }
        return maxLen;


    }
}

