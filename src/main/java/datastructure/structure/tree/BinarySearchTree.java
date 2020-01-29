package datastructure.structure.tree;

import java.util.Stack;

/**
 * 二分搜索树
 * 元素类型要求可比较性
 *
 * @author haze
 * @date created at 2018/9/6 下午3:58
 */
public class BinarySearchTree<E extends Comparable<E>> {
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

    public BinarySearchTree() {
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

    /**
     * 递归删除一个节点
     */
    public void delete(E element) {
        root = delete(root, element);
    }

    private Node delete(Node currentNode, E element) {
        if (currentNode == null) {
            return null;
        }

        if (element.compareTo(currentNode.e) < 0) {
            //修改root.left,赋值给当前root.left
            currentNode.left = delete(currentNode.left, element);
            return currentNode;
        } else if (element.compareTo(currentNode.e) > 0) {
            currentNode.right = delete(currentNode.right, element);
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

    /**
     * 前序遍历:递归实现
     */
    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.e);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    /**
     * 非递归写法:前序遍历
     */
    public void preOrderNonRecursive() {
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            System.out.println("----------");
            return;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 层序遍历
     * 广度优先
     */


    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(11);
        tree.add(1);
        tree.add(3);

        tree.add(8);

        tree.add(29);
        tree.add(5);
        tree.add(4);

        ///-----------------------------------------
        //删除任意元素
        tree.preOrder();
        System.out.println("------------------");
        tree.delete(4);
        tree.preOrder();

//        System.out.println(tree.findMinimum(tree.root).e == 1);
//        tree.preOrder();
//        System.out.println("------------------");
//        tree.removeMinimum();
//        tree.preOrder();
//        System.out.println(tree.findMinimum(tree.root).e == 3);
//        System.out.println("------------------");
//        tree.removeMinimum();
//        tree.preOrder();

//        tree.preOrderNonRecursive();
    }
}
