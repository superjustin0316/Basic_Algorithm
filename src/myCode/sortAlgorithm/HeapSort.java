package myCode.sortAlgorithm;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] nums){
        for(int i = (nums.length-1)/2 ; i >= 0; i--){ //首先整理成完全二叉堆，第一轮排序，最大的数在最前面，之后的数是无序
            siftDownHeapify(nums, i, nums.length); //从i到尾部，依次siftDown
        }

        for(int i = nums.length -1 ; i > 0 ; i--){ //for循环，减少最后一个元素后继续遍历
            swap(nums,0,i);//首尾交换
            siftDownHeapify(nums,0,i); //进行[0,i]siftDown,求出最大值
        }
    }
    public static void siftDownHeapify(int[] nums, int startIndex, int size){
        int child = 2*startIndex + 1;
        while (child < size) {
            if (child + 1 < size && nums[child] <nums[child+1]) {
                child++;
            }
            if (nums[startIndex]<nums[child]) {
                swap(nums,startIndex,child);//
            } else {
                break;
            }
            startIndex = child;
        }
    }
    public  static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,23,30,8,32,31,41,1,15,43,5};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
