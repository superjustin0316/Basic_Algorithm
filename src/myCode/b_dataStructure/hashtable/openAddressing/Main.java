package myCode.b_dataStructure.hashtable.openAddressing;

import myCode.b_dataStructure.hashtable.IHashtable;
import myCode.b_dataStructure.hashtable.openAddressing.impl.HashTableOpenAddressingImpl;


public class Main {

    public static void main(String[] args) {
        IHashtable<Integer,Integer> hashtable = new HashTableOpenAddressingImpl<>();
        hashtable.put(1,1);
        hashtable.put(11,1);
        hashtable.put(21,1);
        hashtable.put(31,1);
        hashtable.put(42,1);


        hashtable.print();
        hashtable.put(45,1);
        hashtable.delete(21);
        hashtable.print();



    }
}
