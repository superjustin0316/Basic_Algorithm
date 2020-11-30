package myCode.a_dataStructure.queue;

public interface Myqueue<E> {
    int size();
    boolean isEmpty();
    //查看栈顶元素
    E peek();

    void print();
    boolean offer(E e);
    E poll();

}
