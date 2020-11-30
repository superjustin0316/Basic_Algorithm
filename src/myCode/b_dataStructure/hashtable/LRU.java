package myCode.b_dataStructure.hashtable;
import java.util.HashMap;

public class LRU {
    class Node{
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int remainCapacity;
    private Node head;
    private Node tail;

    public void LRUCache(int capacity){
        map = new HashMap<>();
        this.remainCapacity = capacity;
        head=null;
        tail=null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return  -1;
        }
        if (node != tail) {
            if (node == head){
                head= head.next;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next =null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value){
        Node node = map.get(key);//判断有还是没有
        if (node != null) {//空间里有该节点->修改节点信息,并将节点放到结尾
            node.value = value;
            if (node != tail) {
                if (node == head){
                    head= head.next;
                }else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next =null;
                tail = node;
            }
        }else{//空间里没有该节点->加入节点
            //空间已满：删除先加入的头部元素+加入
            Node newNode = new Node(key,value);
            if (remainCapacity ==0){
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                remainCapacity++;
            }
            //空间没满：
            if (head == null && tail == null){//加入的元素为空间里的第一个
                head = newNode;
            }else {//加入的元素不为空间里的第一个
                tail.next = newNode;//tail表示结尾元素，newNode与结尾元素建立关系
                newNode.pre = tail;
                newNode.next=null;
            }
            tail = newNode;
            map.put(key,newNode);
            remainCapacity--;

        }

    }
}
