package datastructure.tree;

/**
 * G.M.Adelson-Velsky与E.M.Landis->AVL
 * 一种经典的平衡二叉树
 * 定义:
 * 左右子树高度差<=1
 *
 * @author haze
 * @date created at 2018/9/10 上午11:50
 */
public class AVLTree<K extends Comparable<K>, V> {

    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        /**
         * 树的高度
         */
        private int height;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            //初始化一个节点,其高度为1
            this.height = 1;
        }
    }

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 简洁递归
     */
    public void put(K key, V val) {
        root = add(root, key, val);
    }

    private Node add(Node node, K key, V val) {
        //一开始,往空节点添加子树
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, val);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, val);
        } else {
            //存在该key则覆盖val
            node.val = val;
        }
        //节点的高度:左右子树取大+1
        node.height = 1 + Math.max(
                getNodeHeight(node.left),
                getNodeHeight(node.right)
        );

        //平衡因子
        int balanceFactor = getBalanceFactor(node);
//        if (Math.abs(balanceFactor) > 1) {
//            System.out.println("节点不平衡 height:{}");
//        }

        //LL形态的孙节点,做右旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //RR 孙节点,做左旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //孙节点处于LR,先左旋转node.left再右旋转node
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //孙节点处于RL,先右旋转node.right再左旋转node
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        //结束:将变化后的root返回
        return node;
    }

    /**
     * 计算该节点的平衡因子
     *
     * @return >0:左子树高度大于右子树
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getNodeHeight(node.left) - getNodeHeight(node.right);
    }

    private int getNodeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
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
        Node retNode;
        if (key.compareTo(currentNode.key) < 0) {
            //修改root.left,赋值给当前root.left
            currentNode.left = delete(currentNode.left, key);
            retNode = currentNode;
        } else if (key.compareTo(currentNode.key) > 0) {
            currentNode.right = delete(currentNode.right, key);
            retNode = currentNode;
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
                retNode = rightTree;
            } else if (currentNode.right == null) {
                //不管该节点的右子树是否为null,将其挂接到父节点的左子树
                Node leftTree = currentNode.left;
                currentNode.left = null;
                size--;
                retNode = leftTree;
            } else {
                //假设左右子树都非空,找到右子树的最小子元素,替代[原节点]返回
                //1.查找右子树的最小子元素
                Node newParent = findMinimum(currentNode.right);
                //2.删除右子树的最小子元素 todo 改造为递归,复用维护平衡因子逻辑
//                currentNode.right = removeMinimum(currentNode.right);
                currentNode.right = delete(currentNode.right, newParent.key);
                //3.当前节点的左右子树的父亲设置为新节点
                newParent.left = currentNode.left;
                newParent.right = currentNode.right;

                retNode = newParent;

                //节点的高度:左右子树取大+1
                retNode.height = 1 + Math.max(
                        getNodeHeight(retNode.left),
                        getNodeHeight(retNode.right)
                );


            }

        }
        //平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        //LL形态的孙节点,做右旋转
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //RR 孙节点,做左旋转
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //孙节点处于LR,先左旋转node.left再右旋转node
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //孙节点处于RL,先右旋转node.right再左旋转node
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
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

    /**
     * 右旋转
     * 旋转一个根节点的孙子节点
     *
     * @param y 旧的根节点
     * @return 得到新的根节点
     */
    //       y
    //      / \
    //     x   t4                                 x
    //    / \      新增孙节点z属于LL形态, 右旋转     /  \
    //   z   t3     -------------------->      z     y
    //  / \                                   / \   / \
    // t1  t2                                t1 t2 t3 t4
    //
    public Node rightRotate(Node y) {
        //1.节点挂接变化
        Node x = y.left;
        Node t3 = x.right;

        y.left = t3;
        x.right = y;
        //2.更新height
        y.height = Math.max(getNodeHeight(y.left), getNodeHeight(y.right)) + 1;
        x.height = Math.max(getNodeHeight(x.left), getNodeHeight(x.right)) + 1;
        //返回新的根节点
        return x;
    }

    /**
     * 右旋转
     * 旋转一个根节点的孙子节点
     *
     * @param y 旧的根节点
     * @return 得到新的根节点
     */
    //   y
    //  / \
    // t4  x                                          x
    //    / \          孙节点处于RR形态 左旋转          /  \
    //   t3  z        -------------------->        y     z
    //      / \                                   / \   / \
    //     t1  t2                                t4 t3 t1 t2
    //
    public Node leftRotate(Node y) {
        //1.节点挂接变化
        Node x = y.right;
        Node t3 = x.left;

        x.left = y;
        y.right = t3;

        //2.更新height
        y.height = Math.max(getNodeHeight(y.left), getNodeHeight(y.right)) + 1;
        x.height = Math.max(getNodeHeight(x.left), getNodeHeight(x.right)) + 1;
        //返回新的根节点
        return x;
    }

}
