package myCode.a_dataStructure.stack;

import myCode.a_dataStructure.stack.impl.LinkedListStackImpl;

public class Main {
    public static void main(String[] args){
        //ArrayStackImpl<Integer> stack = new ArrayStackImpl<>();
        LinkedListStackImpl<Integer> stack = new LinkedListStackImpl<>();
        stack.push(1);
        stack.print();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
        stack.print();
        stack.pop();
        stack.print();



    }
}
