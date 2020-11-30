package leetCode;


public class lc215 {
    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0 ; i< nums.length-1 ; i++){
            int index = partition( nums, i,0, nums.length -1)+1;
            System.out.println("index: "+index+" ,  i: "+i);
            if (index == k) {
                return nums[i];
            }
        }

        return 100;
    }

    public static int partition(int[] nums, int pivotIndex, int left, int right){
            int pivot = nums[pivotIndex];
            int l = left;
            int r = right;
            while (l <= r){
                if (nums[l] < pivot && nums[r] > pivot){
                    l++;
                    r--;
                }
                if (nums[l] >= pivot) l++;
                if (nums[r] <= pivot) r--;
            }
            return r;
        }

    public static void main(String[] args) {
        //9,8,7,6,5,4,3,2,1
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        System.out.println(findKthLargest(nums,1));
    }
    }