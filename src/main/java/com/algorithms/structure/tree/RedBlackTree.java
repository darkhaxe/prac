package com.algorithms.structure.tree;

/**
 * @author haze
 * @date created at 2018/9/10 上午11:50
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

}
