// public class stones_weight_II_shit
import java.util.*;
public class stones_weight_II_shit {
    public int solve(int stones[], int index){
        if (stones.length == 1){
            return stones[0];
        }
        if (stones.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = index+1; i<stones.length; i++){
            if (stones[i]==stones[index]){
                ans = Math.min(ans, solve(stones, i+1));
            }else if (stones[i]<=stones[index]){
                stones[i] = stones[index] - stones[i];
                ans = Math.min(ans, solve(stones, index));
            }
        }
        return ans;
    }
    public int lastStoneWeightII(int[] stones) {
        Arrays.sort(stones);
        int res = Integer.MAX_VALUE;
        for(int i=0; i<stones.length; i++){
            res = Math.min(res, solve(stones, i));
        }
        return res;
    }
}
