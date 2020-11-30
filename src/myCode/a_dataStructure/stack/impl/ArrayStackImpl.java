package myCode.a_dataStructure.stack.impl;

import myCode.a_dataStructure.stack.IArrayStack;

public class ArrayStackImpl<E>  implements IArrayStack<E> {

    private E[] data;
    private int elementCount;
    public ArrayStackImpl() {
        this(10);//给capacity设置默认的初始值
    }
    public ArrayStackImpl(int capacity) {
        this.data = (E[]) new Object [capacity];
        this.elementCount = 0;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public void push(E e) {
        if (elementCount == data.length) {
            resize (data.length * 2) ;
        }
        data[elementCount]=e;
        elementCount++;
    }

    @Override
    public void resize(int capacity){
        E[] temp = (E[])new Object[capacity];
        for (int i = 0; i< elementCount ; i++){
            temp[i] = data[i];
        }
        data = temp;//交换内存地址，相当于指针
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("空栈警告");
        }
        E obj = peek();
        elementCount--;
        data[elementCount] = null;
        return obj;


    }
    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("空栈警告");
        }
        return data[elementCount - 1];
    }

    public void print(){
        System.out.println("size:"+elementCount+"  ");
        System.out.println("capacity:"+data.length+"  ");
        for(int i = 0; i<elementCount; i++){
            System.out.print(data[i] + " ");
        }
    }


}
