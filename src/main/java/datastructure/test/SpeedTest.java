package datastructure.test;

import datastructure.tree.Trie;

import java.util.ArrayList;

/**
 * @author haze
 * @date created at 2020/5/30 8:52 下午
 */
public class SpeedTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

//            BSTSet<String> set = new BSTSet<>();
//            for(String word: words)
//                set.add(word);
//
//            for(String word: words)
//                set.contains(word);
//
            long endTime = System.nanoTime();
//
//            double time = (endTime - startTime) / 1000000000.0;
//
//            System.out.println("Total different words: " + set.getSize());
//            System.out.println("BSTSet: " + time + " s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words)
                trie.add(word);

            for (String word : words)
                trie.contains(word);

            endTime = System.nanoTime();

            double cost = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + cost + " s");
        }
    }
}
