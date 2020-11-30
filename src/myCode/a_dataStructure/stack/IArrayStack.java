package myCode.a_dataStructure.stack;

public interface IArrayStack<E> {

    int capacity();
    int size();
    boolean isEmpty();
    //入栈
    void push(E e);
    //查看栈顶元素
    E peek();
    //删除元素，出栈
    E pop();

    void print();

    void resize(int capacity);

}
