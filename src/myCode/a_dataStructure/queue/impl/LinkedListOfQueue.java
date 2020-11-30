package myCode.a_dataStructure.queue.impl;

import myCode.a_dataStructure.queue.Myqueue;

public class LinkedListOfQueue<E> implements Myqueue<E> {

    private  ListNode head;
    private  ListNode tail;
    private  int size;
    public LinkedListOfQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E e) {
        if (tail == null) {//初始化
                tail = new ListNode(e);
                head = tail;
            }else {
                tail.next = new ListNode(e);
                tail = tail.next;
            }
        size++;
        return true;
    }
    @Override
    public E poll() {
        if (isEmpty()) {
            System.out.println("队伍为空");
        }
        ListNode res = head;
        head = head.next;
        res.next = null;
        if (head == null) {
            tail = null;
        }
        size --;
        return (E) res.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("队伍为空");
        }
        return  (E) head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void print(){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data +"->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode<E> {

        public E data;

        public ListNode next;

        public  ListNode(E data) {
            this.data = data;
            this.next = null;
        }

    }
}

