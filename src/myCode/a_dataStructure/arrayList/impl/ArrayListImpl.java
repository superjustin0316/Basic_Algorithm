package myCode.a_dataStructure.arrayList.impl;


import myCode.a_dataStructure.arrayList.IArrayList;

public class ArrayListImpl implements IArrayList{
    private int[] data;
    private int size;

//初始化
    public ArrayListImpl(int capacity){
        this.data = new int[capacity];
        this.size = 0;
    }

    @Override
    public int capacity(){
        return data.length;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return (size == 0);
    }

    //在末尾加数
    @Override
    public void add1(int element) {
        if (size == data.length){
            resize(data.length*2);//扩容！
        }
        data[size] = element;
        size++;
    }

    //增2
    @Override
    public void add2(int index, int element) {
        if (size == data.length){
            resize(data.length*2);//扩容！
        }
//        for ( int i =index; i<size; i++){
//              data[i+1]=data[i];
//        }易错点！前移和后移的覆盖方向
        for ( int i =size -1; i>=index; i--){
              data[i+1]=data[i];
        }
        data[index] = element;
        size++;

    }
    //是否含有
    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    //查
    @Override
    public int get(int index) {
        return (data[index]);
    }
    //修改
    @Override
    public void set(int index, int element) {
        data[index]= element;
    }



    @Override
    public void removeIndex(int index){
        for (int i = index; i<size; i++){
        data[i]=data[i+1];
        }
        size--;
        if (data.length / 4 >= size && data.length /2 !=0){
            resize(data.length/2);//缩容！！
        }
    }

    @Override
    public void removeElement(int element){
        for (int i =0; i<size; i++) {
            if (data[i] == element) {
                removeIndex(i);
            }
        }

    }

    @Override
    public void print(){
        System.out.println("size:"+size+"  ");
        System.out.println("capacity:"+data.length+"  ");
        for(int i = 0; i<size; i++){
            System.out.print(data[i] + " ");
        }
    }

    @Override
    public void resize(int capacity){
        int[] temp = new int[capacity];
        for (int i = 0; i< size ; i++){
            temp[i] = data[i];
        }
        data = temp;//交换内存地址，相当于指针
    }
}
