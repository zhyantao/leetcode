package MyStruct.MyGraph;

public class Edge {

    public int weight; // 边的权值（通常指的是距离）
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
