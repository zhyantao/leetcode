package Templates.Graph;

import MyStruct.MyGraph.Edge;
import MyStruct.MyGraph.Graph;
import MyStruct.MyGraph.Node;

import java.util.*;

// 仅可用于无向图的最小生成树
public class Kruskal {

    // 并查集的简单实现
    public static class UnionFind {

        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> nodes) {
            this.fatherMap.clear();
            this.sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node n) {
            Stack<Node> path = new Stack<>();
            while (n != fatherMap.get(n)) {
                path.add(n);
                n = fatherMap.get(n);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), n);
            }
            return n;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }

            Node aFather = findFather(a);
            Node bFather = findFather(b);

            if (aFather != bFather) {
                int aSetSize = sizeMap.get(aFather);
                int bSetSize = sizeMap.get(bFather);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aFather, bFather);
                    sizeMap.put(bFather, aSetSize + bSetSize);
                    sizeMap.remove(aFather);
                } else {
                    fatherMap.put(bFather, aFather);
                    sizeMap.put(aFather, aSetSize + bSetSize);
                    sizeMap.remove(bFather);
                }

            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    // Kruskal 算法
    public static Set<Edge> kruskal(Graph graph) {

        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());

        // 按照权重构建小顶堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }

        Set<Edge> ans = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                ans.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }

        return ans;
    }

}
