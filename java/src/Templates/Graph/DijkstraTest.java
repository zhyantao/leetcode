package Templates.Graph;

import MyStruct.MyGraph.Graph;
import MyStruct.MyGraph.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * input.txt 内容如下：
 * <p>
 * 4 5
 * 0 1 15
 * 1 2 15
 * 0 3 50
 * 1 3 30
 * 2 3 10
 * 3
 */

public class DijkstraTest {

    // 求单源最短路径
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int N = in.nextInt(); // 路标数量
        int P = in.nextInt(); // 通道数量

        int[][] arr = new int[P][3];

        for (int i = 0; i < P; i++) {
            int A = in.nextInt(); // 起点路标编号
            int B = in.nextInt(); // 终点路标编号
            int T = in.nextInt(); // 路标 A 到 B 的时间
            arr[i][0] = T;
            arr[i][1] = A;
            arr[i][2] = B;
        }
        int X = in.nextInt(); // 裁判给定的终点路标编号

        int ans = process(arr, N, X);
        System.out.println(ans);
    }

    private static int process(int[][] arr, int N, int X) {

        Graph graph = Matrix2Graph.matrix2graph(arr);

        HashMap<Node, Integer> map = Dijkstra.dijkstra(graph.nodes.get(0));

        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            Node key = entry.getKey();
            int value = entry.getValue();
            System.out.println("0" + " -> " + key.val + " : " + value);
        }

        return map.get(graph.nodes.get(X));
    }

}
