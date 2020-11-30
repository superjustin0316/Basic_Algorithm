package myCode.a_dataStructure.queue;

import myCode.a_dataStructure.queue.impl.ArrayCircularOfQueueImpl;
import myCode.a_dataStructure.queue.impl.ArrayOfQueueImpl;
import myCode.a_dataStructure.queue.impl.LinkedListOfQueue;

public class Main {
    public static void testLinkedListOfQueue(){
        Myqueue<Integer> queue = new LinkedListOfQueue<>();
        for (int i = 0; i< 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayOfQueue(){
        Myqueue<Integer> queue = new ArrayOfQueueImpl<>();
        for (int i = 0; i< 11; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }
    public static void testArrayCircularOfQueue(){
        Myqueue<Integer> queue = new ArrayCircularOfQueueImpl<>();
        for (int i = 0; i< 9; i++) {
            queue.offer(i);
           // queue.print();
        }
        queue.print();
        queue.poll();queue.poll();queue.poll();
        queue.print();
        queue.offer(11);queue.offer(21);queue.offer(31);queue.offer(41);
        queue.print();
        System.out.println(queue.peek());
    }

    public static void main(String[] args) {
        testArrayCircularOfQueue();

    }
}
