package myCode.a_dataStructure.stack.impl;

import myCode.a_dataStructure.stack.ILinkedListStack;

import java.util.LinkedList;

public class LinkedListStackImpl<E> implements ILinkedListStack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStackImpl(){
        this.linkedList = new LinkedList<>();
    }

    @Override
    public  int size(){
        return linkedList.size();
    }

    @Override
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e){
        linkedList.addFirst(e);
    }

    @Override
    public E pop(){
        return linkedList.removeFirst();
    }
    @Override
    public E peek(){
        return linkedList.getFirst();
    }

    public void print(){
        System.out.println("size: "+linkedList.size());
        for(int i = 0; i<linkedList.size(); i++){
            System.out.print(linkedList.get(i) + " ");
        }
    }


}
