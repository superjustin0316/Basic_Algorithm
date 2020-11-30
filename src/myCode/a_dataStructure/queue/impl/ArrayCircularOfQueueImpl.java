package myCode.a_dataStructure.queue.impl;

import myCode.a_dataStructure.queue.Myqueue;

public class ArrayCircularOfQueueImpl<E> implements Myqueue<E> {

    private E[] data;
    private int head;
    private int tail;
    public ArrayCircularOfQueueImpl(){
        this(10);
    }
    public ArrayCircularOfQueueImpl(int capacity){
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public int size() {
        return (tail - head + data.length)% data.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E peek() {
        return data[head];
    }

    @Override
    public void print() {
        System.out.println("size: "+size());
        System.out.println("capacity: "+data.length);
        for (int i = 0 ;i<data.length;i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();

    }

    @Override
    public boolean offer(E e) {
        data[tail] = e;
        tail = (tail+1)%data.length;
        if (tail == head) {
            resize(data.length *2);
        }
        return false;
    }

    @Override
    public E poll() {
        E obj = data[head];
        data[head]= null;
        head =(head +1 ) % data.length;
        return  obj;
    }



    public void resize(int capacity){
        E[] temp= (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++ ) {
            temp[i] = data[(i + head) % data.length];
        }
        head = 0;
        tail = data.length;
        data = temp;
    }
}
