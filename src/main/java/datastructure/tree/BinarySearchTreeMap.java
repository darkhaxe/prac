package datastructure.tree;

import datastructure.collection.Map;

/**
 * 二分搜索树,实现映射类
 *
 * @author haze
 * @date created at 2018/9/6 下午3:58
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    private class Node {
        public K key;
        public V val;
        public Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTreeMap() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 简洁递归
     */
    public void put(K key, V val) {
        root = add(root, key, val);
    }

    private Node add(Node root, K key, V val) {
        //一开始,往空节点添加子树
        if (root == null) {
            size++;
            return new Node(key, val);
        }

        if (key.compareTo(root.key) < 0) {
            root.left = add(root.left, key, val);
        } else if (key.compareTo(root.key) > 0) {
            root.right = add(root.right, key, val);
        } else {
            //存在该key则覆盖val
            root.val = val;
        }
        //结束:将变化后的root返回
        return root;
    }

    /**
     * 递归删除一个节点
     */
    public V delete(K key) {
        V val = get(key);
        //节点存在才进行删除
        if (val != null) {
            root = delete(root, key);
        }
        return val;
    }

    public V get(K key) {

        Node node = getNode(root, key);

        return node != null ? node.val : null;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    private Node delete(Node currentNode, K key) {
        if (currentNode == null) {
            return null;
        }

        if (key.compareTo(currentNode.key) < 0) {
            //修改root.left,赋值给当前root.left
            currentNode.left = delete(currentNode.left, key);
            return currentNode;
        } else if (key.compareTo(currentNode.key) > 0) {
            currentNode.right = delete(currentNode.right, key);
            return currentNode;
        } else {
            //找到了待删除的元素,进行处理
            //待删除节点的三种情况
            //1.节点的左子树为null,则获取[待删除节点]的右子树引用,将该引用return,
            //假设一个嵌套2次的调用,root.left.left=rightTree
            if (currentNode.left == null) {
                //不管该节点的右子树是否为null,将其挂接到父节点的左子树
                Node rightTree = currentNode.right;
                //断掉原来的rightTree
                currentNode.right = null;
                size--;
                return rightTree;
            }
            if (currentNode.right == null) {
                //不管该节点的右子树是否为null,将其挂接到父节点的左子树
                Node leftTree = currentNode.left;
                currentNode.left = null;
                size--;
                return leftTree;
            }
            //假设左右子树都非空,找到右子树的最小子元素,替代[原节点]返回
            //1.查找右子树的最小子元素
            Node newParent = findMinimum(currentNode.right);
            //2.删除右子树的最小子元素
            currentNode.right = removeMinimum(currentNode.right);
            //3.当前节点的左右子树的父亲设置为新节点
            newParent.left = currentNode.left;
            newParent.right = currentNode.right;

            return newParent;
        }
    }

    private Node findMinimum(Node current) {
        if (current == null) {
            return null;
        }
        if (current.left == null) {
            return current;
        }
        return findMinimum(current.left);
    }

    /**
     * 删除最小元素
     */
    private Node removeMinimum(Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.left != null) {
            currentNode.left = removeMinimum(currentNode.left);
            return currentNode;
        }
        Node rightTree = currentNode.right;
        currentNode = null;
        size--;
        return rightTree;
    }

    public void removeMinimum() {
        root = removeMinimum(root);
    }


    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node root, K key) {
        if (root == null) {
            return false;
        }
        if (key.compareTo(root.key) == 0) {
            return true;
        }
        if (key.compareTo(root.key) < 0) {
            return contains(root.left, key);
        } else {
            return contains(root.right, key);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        BinarySearchTreeMap<Integer, String> tree = new BinarySearchTreeMap<>();
        tree.put(11, "aa");
        tree.put(1, "bb");
        tree.put(3, "c");

        tree.put(8, "d");

        tree.put(29, "e");
        tree.put(5, "f");
        tree.put(4, "g");

        ///-----------------------------------------
        System.out.println(tree.contains(29));
        //删除任意元素
        System.out.println("------------------");
        System.out.println(tree.delete(4));
        System.out.println(tree.delete(3));
        System.out.println(tree.delete(8));
        System.out.println(tree.delete(4));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(8));

    }
}
