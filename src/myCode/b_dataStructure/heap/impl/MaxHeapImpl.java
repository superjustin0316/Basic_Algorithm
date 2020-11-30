package myCode.b_dataStructure.heap.impl;

import myCode.b_dataStructure.heap.IMaxHeap;

public class MaxHeapImpl<E extends Comparable<E>> implements IMaxHeap<E> {

    private int capacity;
    private int size;
    private E[] data;

    public MaxHeapImpl(E[] data) {
        this.capacity = data.length;
        this.size = data.length;
        this.data = data;
        heapify(data);
    }

    public MaxHeapImpl() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }

    public void heapify(E[] data) {
        for (int i = getParentIndex(size - 1); i >= 0; i--) {
            siftDownHeapify(i);
        }
    }

    private void siftDownHeapify(int index) {
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && rightChild(index).compareTo(leftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;//层层下沉
        }
    }

    //扩容
    private void expandCapacity() {
        E[] temp = (E[]) new Comparable[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            temp[i] = data[i];
        }
        capacity = capacity * 2;
        data = temp;
    }

    //添加新的元素：将元素放到最后，然后siftUp
    @Override
    public boolean offer(E e) {
        if (data.length == size) {
            expandCapacity();
        }
        data[size] = e;
        size++;
        siftUp();
        return true;
    }

    //弹出堆顶的元素：把最后的元素变为最前面的元素，然后siftDown
    @Override
    public E poll() {
        E item = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown();
        return item;
    }

    //返回堆顶的元素
    @Override
    public E peek() {
        return data[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //堆的本质是数组
    @Override
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    //加入结点后的操作
    private void siftUp() {
        int index = size - 1;    //将元素放在末尾
        while (getParentIndex(index) >= 0 && parent(index).compareTo(data[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);

        }
    }

    //删除结点后的操作
    private void siftDown()  {//删除头结点
        int index = 0;
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && rightChild(index).compareTo(leftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;//index始终表示插入数值的index
        }
    }

    /**根据公式求index，return index
     */
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    /**调用程序，return data[index]
     */
    private E leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private E rightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    private E parent(int index) {
        return data[getParentIndex(index)];
    }

    private void swap(int i, int j) {//根据index交换数组中的值
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}








