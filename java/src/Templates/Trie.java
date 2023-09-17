package Templates;

import MyStruct.TrieNode;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 向前缀树中插入字符串
    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] chs = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        int index = 0;

        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) != 0) { // 确定树中确实加入过 word，才删除
            char[] chs = word.toCharArray();

            TrieNode node = root;
            node.pass--;
            int index = 0;

            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (--node.nexts[index].pass == 0) {
                    // 这种释放空间非方式只有 Java 能用，JVM 会帮助管理空间
                    // C++ 则需要一条一条释放，不能直接 return
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    // 查询 word 出现过几次
    public int search(String word) {
        if (word == null) {
            return 0;
        }

        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;

        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }

        return node.end;
    }

    // 查询所有字符串中，有几个字符串是以 pre 作为前缀的
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }

        char[] chs = pre.toCharArray();
        TrieNode node = root;
        int index = 0;

        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }

        return node.pass;
    }

}
