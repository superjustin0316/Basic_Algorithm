package myCode.a_dataStructure.linkedList.impl;

import myCode.a_dataStructure.linkedList.IlinkedList;
import myCode.a_dataStructure.linkedList.ListNode;

public class LinkedListImpl implements IlinkedList {

    private int size;
    private ListNode dummy;

    public LinkedListImpl(){
        this.dummy = new ListNode(0);
        this.size = 0;
    }

    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void addIndex(int index, int data){
        ListNode prev = dummy;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        size++;
    }
    @Override
    public void addFirst(int data){
        addIndex(0,data);
    }
    @Override
    public void addLast(int data){
        addIndex(size-1,data);
    }

    @Override
    public int removeIndex(int index){
        ListNode prev = dummy;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.data;
    }

    @Override
    public int removeFirst(){
        return removeIndex(0);
    }
    @Override
    public int removeLast(){
        return removeIndex(size -1);
    }
    @Override
    public boolean removeElement(int data){
        ListNode prev = dummy;
        while (prev.next != null){
            if( prev.next.data == data){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int get(int index){
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }
    @Override
    public void set(int index,int data) {
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    @Override
    public boolean contains(int data) {
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
