package MyStruct.MyGraph;

import java.util.ArrayList;

public class Node {

    public int val; // 该点的编号
    public int in;  // 入度
    public int out; // 出度

    public ArrayList<Node> nexts; // 无向边（或有向边指向）的邻居节点
    public ArrayList<Edge> edges; // 无向边（或由自己发出的有向边）

    public Node(int val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
