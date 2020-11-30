package myCode.a_dataStructure.arrayList;

import myCode.a_dataStructure.arrayList.impl.ArrayListImpl;

public class Main  {
    public static void main(String[] args){
        ArrayListImpl arrayList= new ArrayListImpl(100);
        for(int i=10; i<20;i++){
            int n = i;
            arrayList.add1(n);
            System.out.println("已添加"+i);
        }
        arrayList.removeElement(15);
        arrayList.add2(0,11111);

        boolean b = arrayList.contains(12);
        System.out.println(b);

        arrayList.print();


    }

}
