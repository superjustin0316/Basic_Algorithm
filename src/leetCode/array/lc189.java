package leetCode.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class lc189 {
    public static void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if (i<k){
                nums2[k-1-i] = nums[nums.length - 1-i];
            }else{
                nums2[i] = nums[i-k];
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {-1,-100,3,99};

        rotate(array,2);
        System.out.println(Arrays.toString(array));


    }
}
