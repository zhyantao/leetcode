package MyStruct;

// 前缀树
public class TrieNode {

    public int pass; // 有多少个字符串经过该节点
    public int end; // 有多少个字符串以该节点作为结尾
    public TrieNode[] nexts;
    // HashMap<Char, Node> nexts; // 如果不是字母就不止 26 条路了，用哈希表表达
    // TreeMap<Char, Node> nexts;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        this.nexts = new TrieNode[26]; // 26 个字母
        // nexts[0] == null 表示没有走向 'a' 的路
        // nexts[0] != null 表示有走向 'a' 的路
        // ...
        // nexts[25] != null 表示有走向 'z' 的路
    }
}
