//package myLeetcode;
//
//import java.util.Arrays;
//
//public class leetcode283 {
//    public static void moveZeroesWithBubble( int[] nums) {
//        for (int i = 0;i <nums.length; i++) {
//            System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(nums));
//            for(int j = i+1; j<nums.length; j++ ) {
//                if (nums[i] == 0) {
//                    int temp = nums[j];
//                    nums[j] = nums[i];
//                    nums[i] = temp;
//                }
//                System.out.println("第"+(i+1)+"轮步骤"+ Arrays.toString(nums));
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[] {5,2,0,9,0,4,7,0,6,1,3,8,0,0};
//        moveZeroesWithBubble(nums);
//
//    }
//}
