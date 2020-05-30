package datastructure.tree;

import java.util.TreeMap;

/**
 * 字典树
 *
 * @author haze
 * @date created at 2020/5/30 7:51 下午
 */
public class Trie {

    private class Node {
        /**
         * 是否在此字符形成一个单词
         */
        private boolean isEndChar;
        /**
         * Q:为什么使用TreeMap作为每一个节点的next指针?
         * A:从根节点开始,形成一颗多叉树,每一叉的key是c,value是next指向该路的下一个节点,
         * 下一个节点也支持多叉,因此实现为Map
         */
        private TreeMap<Character, Node> next;

        public Node() {
            this.isEndChar = false;
            this.next = new TreeMap<>();
        }
    }

    /**
     * 根节点的c为空,不放置任何字符
     */
    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public void add(String word) {
        Node curNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.next.get(c) == null) {
                curNode.next.put(c, new Node());
            }

            curNode = curNode.next.get(c);

        }
        //将最后一个字符标记为结束
        //排查重复添加的情况,如果新加入的单词已经存在,此标志位为true
        if (!curNode.isEndChar) {
            size++;
            curNode.isEndChar = true;
        }

    }

    public boolean contains(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.next.get(c) == null) {
                return false;
            }

            curNode = curNode.next.get(c);
        }
        //panda存在,pan不存在,因此输入为pan时,需要确定最后一个node的isEndChar=true
        return curNode.isEndChar;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("pan");
        trie.add("panda");
        System.out.println(
                trie.contains("pan")
        );
        System.out.println(

                trie.contains("pand")
        );
    }
}
