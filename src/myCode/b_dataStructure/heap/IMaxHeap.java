package myCode.b_dataStructure.heap;

public interface IMaxHeap<E> {
    boolean offer(E e);
    E poll();
    E peek();
    void heapify(E[] data);
    int size();
    boolean isEmpty();
    void print();




}
