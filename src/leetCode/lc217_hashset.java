package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class lc217_hashset {

    public boolean lc217a(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.containsKey(num)){
                return  true;//判断有无
            } else {
                map.put(num ,1);
            }
        }
        return  false;
    }


    public boolean lc217b(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length;i++){
            if (!set.add(nums[i])) {
                return  true;
            }
        }
        return false;
    }
}
