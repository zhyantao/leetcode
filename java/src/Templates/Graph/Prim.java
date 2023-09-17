package Templates.Graph;

import MyStruct.MyGraph.Edge;
import MyStruct.MyGraph.Graph;
import MyStruct.MyGraph.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// 仅可用于无向图，生成最小生成树
public class Prim {

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph) {

        // 每向集合中加入一个点，解锁它的邻接边，解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();

        // 将挑选出来的边加入 ans
        Set<Edge> ans = new HashSet<>();

        // for 循环处理森林的问题，如果不是森林，而是一棵树，只需要跑 for 循环内部的算法即可
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {

                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }

                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;

                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        ans.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return ans;
    }

}
