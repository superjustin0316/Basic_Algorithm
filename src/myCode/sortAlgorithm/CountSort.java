package myCode.sortAlgorithm;

import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]]+1;
        }//出现一次就在相应位置+1

        System.out.println(Arrays.toString(count));

        int index = 0;
        for (int i =0; i <= max ; i++) {
            for (int j =0; j <count[i]; j++) {
                nums[index++] = i;
            }
        } //相同元素多次输出

        System.out.println(Arrays.toString(nums));
    }

    public  static  void main (String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        countSort(nums);
    }
}
