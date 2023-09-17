package Templates.Graph;

import MyStruct.MyGraph.Graph;
import MyStruct.MyGraph.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        stack.add(node);
        set.add(node);

        System.out.println(node.val);

        while (!stack.isEmpty()) {

            Node cur = stack.pop();

            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur); // 重新压入 cur
                    stack.push(next);
                    set.add(next);

                    System.out.println(next.val);

                    break;
                }
            }
        }
    }

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
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        //int N = in.nextInt(); // 路标数量
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
        //int X = in.nextInt(); // 裁判给定的终点路标编号

        // 构建图结构
        Graph graph = Matrix2Graph.matrix2graph(arr);
        dfs(graph.nodes.get(0)); // 深度优先遍历
    }

}
