package com.algorithms.structure.tree;

/**
 * 二分搜索树
 *
 * @author haze
 * @date created at 2018/9/6 下午3:58
 */
//元素类型要求可比较性
public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 简洁递归
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node root, E e) {
        //一开始,往空节点添加子树
        if (root == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        } else {
            ;
        }
        //结束:将变化后的root返回
        return root;
    }


//    @Deprecated
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//    }
//
//    /**
//     * 繁琐写法
//     * 递归添加元素
//     */
//    @Deprecated
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        }
//        //e小于node.e,则插入左节点
//        //e大于node.e,则插入右节点
//        //简单情况:左右子树为空,直接添加到挂到node下
//        if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
////递归
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }


    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        }
        if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
