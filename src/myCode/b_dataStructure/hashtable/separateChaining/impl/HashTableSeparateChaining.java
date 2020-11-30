package myCode.b_dataStructure.hashtable.separateChaining.impl;

import myCode.b_dataStructure.hashtable.IHashtable;
import myCode.b_dataStructure.hashtable.separateChaining.HashNode;

public class HashTableSeparateChaining<K,V> implements IHashtable<K,V> {

    private HashNode[] hashNodes;
    private int capacity;
    private int size;

    public HashTableSeparateChaining() {
        this.capacity = 5;
        hashNodes = new HashNode[capacity];
    }
    public HashTableSeparateChaining(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }
    private int hash(K key){
        return key.hashCode() % capacity;// key -> hashcode -> index
    }

    @Override
    public void put(K key, V val) {
        HashNode<K,V> hashNode = new HashNode<>(key,val);
        int index = hash(key);

        HashNode curNode = hashNodes[index];
        HashNode preNode = null;

        /**
           1. 判读当前节点是否为空
           2.1 找到节点的值，修改
           2.2 链表node向后走，把节点加到最后
         **/
        if (curNode == null) {
            hashNodes[index] = hashNode;
        } else {
            while (curNode != null){
                if (curNode.key.equals(key)){
                    curNode.value = val;
                    return;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            preNode.next = hashNode;//与已有节点建立连接，写入（key，val）
        }
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        HashNode curNode = hashNodes[index];

        //进行遍历，找到节点
        while (curNode != null) {
            if (curNode.key.equals(key)) {
                return (V) curNode.value;
            }
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int index = hash(key);
        HashNode curNode = hashNodes[index];//获取index；key->hashcode->index(确定链表的起始位置)
        HashNode preNode = null;

        while (curNode != null){
            if (curNode.key.equals(key)){
               break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        /**
         * 1.链表位置是否有元素
         * 2.1要删除的元素是否为链表中的第一个
         * 2.2要删除的元素是链表的第n个元素
         */

        if (curNode == null){
            return  null;//表内无元素.
        }else if (preNode == null){
            hashNodes[index] = curNode.next;//要删除的元素为第一个
        }else {
            preNode.next = curNode.next;//要删除的元素不是第一个
        }
        size--;
        return (V) curNode.value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (HashNode<K,V> hashNode:hashNodes){
            if (hashNode!= null){
                while ((hashNode != null)){
                    System.out.print("key:"+hashNode.key+" value :"+hashNode.value+"->");
                    hashNode = hashNode.next;
                }
                System.out.print("null");
            }
        }
        System.out.println("size: "+size);

    }
}
