package datastructure.structure;

/**
 * @author haze
 * @date created at 2020/1/30 4:51 下午
 */
public interface Map<K, V> {

    void put(K key, V val);

    V get(K key);

    V delete(K key);

    boolean contains(K key);
}
