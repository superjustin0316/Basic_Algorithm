package myCode.a_dataStructure.arrayList;

public interface IArrayList {
    int capacity();
    int size();
    boolean isEmpty();


    void add1(int element);

    void add2(int index, int element);

    boolean contains(int element);

    int get(int index);

    void set(int index,int element);

    void removeIndex(int index);

    void removeElement(int element);

    void print();

    void resize(int capacity);

}
