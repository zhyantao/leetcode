package MyStruct.MyGraph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

    // key    节点编号（用来找节点）
    // value  节点内的值（用来记录节点信息）
    // 一般来讲简单的图，key 和 value 是相等的
    public HashMap<Integer, Node> nodes;

    // 边集
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

}
