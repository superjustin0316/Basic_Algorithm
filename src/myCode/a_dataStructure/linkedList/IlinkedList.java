package myCode.a_dataStructure.linkedList;

public interface IlinkedList   {

    int size();
    boolean isEmpty();

    void addIndex(int index, int data);
    void addFirst(int data);
    void addLast(int data);

    int removeFirst();
    int removeLast();
    boolean removeElement(int data);
    int removeIndex(int index);

    int get(int index);
    void set(int index, int data);

    boolean contains(int data);


}
