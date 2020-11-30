package myCode.a_dataStructure.stack;

public class StackRecursion {
    public static void test(){
        test1();
    }

    public static void test1(){
        System.out.println("这是第1个调用");
        test2();
        System.out.println("第1个调用结束");
    }

    public static  void test2(){
        System.out.println("这是第2个调用");
        test3();
        System.out.println("第2个调用结束");
    }

    public static  void test3(){
        System.out.println("这是第3个调用");
        System.out.println("第3个调用结束");
    }

    public static void main(String[] args) {
        test();
    }
}
