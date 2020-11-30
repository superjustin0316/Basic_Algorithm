package myCode.sortAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 时间复杂度：O（n^2）
     * 最好：O（n）-->代码优化
     * 最坏：O（n^2）
     * 平均：O（n^2）
     * 空间复杂度:：O（1）
     * @param nums
     */
    public  static void bubbleSort(int[] nums){
        for (int i=0;i < nums.length-1 ; i++) {
            System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(nums));
//            for (int j = nums.length-1 ; j>1; j--){
            for (int j =i+1; j <nums.length ; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                System.out.println("第"+(i+1)+"轮步骤"+ Arrays.toString(nums));
            }

        }
    }

    public static void bubbleSortBest(int[] nums){
        boolean flag = false;
        for (int i=0;i < nums.length-1 ; i++) {
            flag = false;
            System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(nums));
            for (int j = nums.length-1 ; j>1; j--){
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    flag = true;
                }
                System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(nums));
            }
            //优化
            if (!flag) {
                break;
            }

        }
    }

    public static void main (String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        bubbleSort(nums);
    }
}
