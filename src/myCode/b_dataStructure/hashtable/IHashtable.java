package myCode.b_dataStructure.hashtable;

public interface IHashtable<K,V> {

    void put( K key, V val);

    V get(K key);

    V delete(K key);

    boolean isEmpty();

    int size();

    void print();
}
