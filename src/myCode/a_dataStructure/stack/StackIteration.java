package myCode.a_dataStructure.stack;

public class StackIteration {
    public static int sum;
    public static void sum0fN(int num) {
        if (num == 0) {
            return;
        }
        sum=sum+num;
        sum0fN(num-1);
    }
    public static int sum0fN2(int num) {
        if (num == 0) {
            return 0;
        }
        return num + sum0fN2(num-1);
    }

    public static int iteration(int num){
        int sum = 0;
        int n = 1 ;
        while(n <= num) {
            sum = sum +n;
            n++;
        }
        return sum ;
    }

    public static void main(String[] args) {
        System.out.println(sum0fN2(10));
        System.out.println(iteration(10));
    }
}
