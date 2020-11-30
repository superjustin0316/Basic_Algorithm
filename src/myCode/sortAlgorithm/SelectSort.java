package myCode.sortAlgorithm;

public class SelectSort {
    /**
     * 时间复杂度:
     * 最好O(1)
     * 最坏O(n^2)
     * 平均O(n^2)
     * 空间复杂度:O(1)
     * @param nums
     */
    public  static  void selectSort(int[] nums) {
        for (int i = 0; i < nums.length -1 ;i++) {
            int minIndex = i;
            for (int j = i+1; j< nums.length - 1; i++ ) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex]= temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        selectSort(nums);
    }
}
