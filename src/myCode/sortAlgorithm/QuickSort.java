package myCode.sortAlgorithm;

public class QuickSort {
    //主程序
    public static void quickSort(int [] nums, int left, int right){
        if (left < right) {
            int pivot = partition(nums, left , right);
            quickSort(nums, left, pivot -1);
            quickSort(nums,pivot +1,right);
        }
    }
    /**
     * 分治法：
     * 以左节点为标准点进行比较
     * 单轮进行交换,然后得到1个数的绝对位置
     */
    public  static int partition (int [] nums, int left , int right) {
        int privotIndex = left;
        int pivot = nums[privotIndex];
        int l = left + 1;
        int r = right;
        //System.out.println("pivot:"+pivot+" "+ Arrays.toString(nums));
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, privotIndex, r);
        //System.out.println("此轮结束："+ Arrays.toString(nums));
        return r;
    }

    public  static void swap(int[] nums, int i, int j) {
        int temp =nums[i];
        nums[i] = nums [j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        quickSort(nums,0,nums.length-1);
    }

}
