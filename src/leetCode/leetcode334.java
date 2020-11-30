//package myLeetcode;
//
//public class leetcode334 {
//    public boolean increasingTriplet(int[] nums) {
//        int min = Integer.MAX_VALUE;
//        int secondMin = Integer.MAX_VALUE;
//        for(int i = 0; i <nums.length;i++ ) {
//            if (min >= nums[i]){
//                    min = nums[i];
//            }else if (secondMin >= nums[i]) {
//                    secondMin = nums[i];
//            }else if (nums[i] > secondMin) {
//                    return true;
//            }
//
//            }
//            return false;
//        }
//}
//
