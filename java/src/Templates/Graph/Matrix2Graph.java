package Templates.Graph;

import MyStruct.MyGraph.Edge;
import MyStruct.MyGraph.Graph;
import MyStruct.MyGraph.Node;

public class Matrix2Graph {

    // 【解题套路】将自己不熟悉的算法转化为模板代码（也就是 Templates 包下的实现）
    // 将格式为 [weight, from, to] 的二维数组转化为 Graph.java 支持的格式
    // [[3, 0, 2], // 由 0 -> 2, 边权为 3
    // [4, 3, 2],
    // [1, 1, 3]]
    public static Graph matrix2graph(int[][] matrix) {

        Graph graph = new Graph();

        // 这段代码【只能用来转化有向图】
        for (int i = 0; i < matrix.length; i++) {

            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];

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

            // 以上代码只能构建有向图，补充下面的代码可以构建无向图
            // 【基本思路】再加一条边既可构成无向图
//            Edge newEdge2 = new Edge(weight, toNode, fromNode);
//            toNode.nexts.add(fromNode);
//            toNode.out++;
//            fromNode.in++;
//            toNode.edges.add(newEdge2);
//            graph.edges.add(newEdge2);
        }

        // 【将孤立节点加入图中】如果不是所有节点都在图中，需要加入以下代码
//        for (int i = 0; i < n; i++) { // n 是节点编号，需要在参数列表中加入这个参数
//            if (!graph.nodes.containsKey(i)) {
//                graph.nodes.put(i, new Node(i));
//            }
//        }

        return graph;
    }

}
