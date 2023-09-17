package Templates.Graph;

import MyStruct.MyGraph.Graph;
import MyStruct.MyGraph.Node;

import java.util.*;

public class TopologySort {

    public static List<Node> topologySort(Graph graph) {

        HashMap<Node, Integer> inMap = new HashMap<>(); // key: 某个 node，value: 剩余的入度
        Queue<Node> zeroInQueue = new LinkedList<>(); // 入度为零的点，才能进入这个队列

        // 寻找入度为零的点
        for (Node node : graph.nodes.values()) { // values() 返回一个 Collection 列表
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        // 拓扑排序
        List<Node> ans = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {

            Node cur = zeroInQueue.poll();
            ans.add(cur);

            // 擦除入读为 0 的点所对应的边
            for (Node next : cur.nexts) {

                // 减少邻接点的入度
                inMap.put(next, inMap.get(next) - 1);

                // 判断临界点的入度是否需要加入 zeroInQueue
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }

        return ans;
    }

}
