package testCase;

import java.util.Arrays;

public class lc26 {
    public static  int removeDuplicates(int[] nums) {
        int res = 0;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] != nums[res]){
                res++;
                nums[res] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("res: "+res);
        return res;
    }
    public static void main(String[] args) {
        int[] array = {0,0,1,1,2,2};
        removeDuplicates(array);

    }
}


