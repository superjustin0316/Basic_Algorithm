package myCode.b_dataStructure.treeArray;
import java.util.Scanner;

public class treeArray {

    public void add(int[] array,int x, int y){
        for (int i = x; i < array.length; i+= lowbit(i)) {
             array[i] += y;
        }
    }

    public int lowbit(int x){
        return x & (x*(-1));
    }

    public int getsum(int[] array, int x){
        int sum = 0;
        for (int i = 0; i < array.length; i+= lowbit(i)) {
            sum += array[i];
        }
        return sum;
    }
//
//    public static void main(String[] args) {
//        Scanner ms = new Scanner(System.in);
//        int element = ms.nextInt();
//        int[] a = new int{1,2,3,4,5,6,7,8,9,10};
//        int[] c = new int[20];
//

//    }
}
