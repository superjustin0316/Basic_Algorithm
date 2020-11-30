package myCode.sortAlgorithm;

import java.util.Arrays;

public class InsertSort {
    /**
     * 时间复杂度：
     * 最好：O（n
     * 最坏：O（n^2）
     * 平均：O（n^2）
     * 空间复杂度:：O（1）
     * @param nums
     */
    public  static  void insertSort(int[] nums) {
        for (int i = 0 ; i  < nums.length-1; i++) {
            System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(nums));
            for (int j = i+1; j >0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }else {
                    break;
                }
            }
            System.out.println("第"+(i+1)+"轮步骤"+ Arrays.toString(nums));
        }
    }
    public  static  void insertBinarySort(int[] nums) {
        /**
         * 时间复杂度：
         * 最好：O（
         * 最坏：O（n^2）
         * 平均：O（n^2）
         * 空间复杂度:：O（1）
         * @param nums
         **/
        for (int i = 0; i < nums.length - 1 ; i++) {
            int temp,low,high,mid;
            System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(nums));
            temp = nums[i+1];
            low = 0;
            high =i;
            while (low <= high) {
                mid = (low + high) /2 ;
                if (nums[mid] < temp) {
                    low = mid +1;
                }else {
                    high = mid -1;
                }
            }
            for (int j =i ; j > high; j--) {
                nums[j+1] = nums[j];
            }
            nums[high+1]=temp;
            System.out.println("第"+(i+1)+"轮步骤"+ Arrays.toString(nums));
        }
    }
    public  static  void main (String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        insertSort(nums);
    }
}
