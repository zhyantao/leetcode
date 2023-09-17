package LeetCode;

import java.util.*;

public class LC0210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ans = new int[numCourses];

        Graph graph = matrix2graph(prerequisites, numCourses);
        List<Node> path = topologySort(graph);

        // 如果不能完成所有课程，返回空数组
        if (path.size() != numCourses) {
            return new int[]{};
        }

        // 打印拓扑排序结果
        for (int k = 0; k < path.size(); k++) {
            ans[k] = path.get(k).val;
        }

        return ans;
    }

    public List<Node> topologySort(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();

        List<Node> ans = new ArrayList<>();

        for (Node node : graph.nodes.values()) { // values() 函数返回 哈希表元素的集合
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node); // 将入度为 0 的节点放入队列
            }
        }

        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();

            ans.add(cur); // 更新结果列表

            // 擦除入度为零的节点，并加入到 zeroInQueue 中
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1); // 更新入度
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }

        return ans;
    }

    public Graph matrix2graph(int[][] matrix, int n) {

        Graph graph = new Graph();

        for (int[] it : matrix) {
            int weight = 0;
            int from = it[1];
            int to = it[0];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }

            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }

        // 遍历所有的编号，如果不在图中，就加入图中
        for (int i = 0; i < n; i++) {
            if (!graph.nodes.containsKey(i)) {
                graph.nodes.put(i, new Node(i));
            }
        }

        return graph;
    }
}

class Node {
    int val;
    int in;
    int out;
    ArrayList<Node> nexts;
    ArrayList<Edge> edges;
    Node (int val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}

class Edge {
    int weight;
    Node from;
    Node to;
    Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;
    Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}