package Templates.Graph;

import MyStruct.MyGraph.Edge;
import MyStruct.MyGraph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

// 允许有负权边，但要求不能有累加和为负数的环
public class Dijkstra {

    // 单源最短路径问题
    public static HashMap<Node, Integer> dijkstra(Node head) {

        // 源节点到其他所有节点的距离，记为 distanceMap
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);

        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceInUnselectedNodes(distanceMap, selectedNodes);

        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceInUnselectedNodes(distanceMap, selectedNodes);
        }

        return distanceMap;
    }

    public static Node getMinDistanceInUnselectedNodes(HashMap<Node, Integer> distanceMap,
                                                       HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

}
