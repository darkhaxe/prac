package com.algorithms.structure;

/**
 * 二分搜索树
 *
 * @author haze
 * @date created at 2018/9/6 下午3:58
 */
//元素类型要求可比较性
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }


    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 递归添加元素
     *
     * @param e
     */
    private void add(Node node, E e) {
        //e小于node.e,则插入左节点
        //e大于node.e,则插入右节点
        if (e.compareTo(node.e) < 0) {
            node.left = new Node(e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = new Node(e);
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
