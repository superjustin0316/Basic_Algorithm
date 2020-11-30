package myCode.a_dataStructure.stack;

public class StackLevel {
    public static int level = 1 ;

    public static void level() {
        level ++ ;
        level();
    }

    public static void main(String[] args) {
        try{
            level();
        } catch (StackOverflowError e) {
            System.out.println(level);
        }
    }
}
