package LeetCode;

import Templates.Trie;

public class LC0820_ShortEncodingOfWords {

    public static int minimumLengthEncoding(String[] words) {

        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            trie.insert(s);
        }

        return 0;
    }

    public static void main(String[] args) {
        minimumLengthEncoding(new String[] {
           "time",
           "me",
           "bell"
        });
    }
}
