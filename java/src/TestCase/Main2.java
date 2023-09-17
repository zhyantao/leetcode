package TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {

    static int max_people = Integer.MIN_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input2.txt"));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                graph[i][j] = scanner.nextInt();
            }
        }
        process(graph, 0, 0, 0);
        System.out.println(max_people);
    }

    public static void process(int[][] graph, int x, int y, int count) {
        for (int i = x; i < graph.length; ++i) {
            for (int j = 0; j < graph[0].length; ++j) {
                if (graph[i][j] == 1) continue;
                if (isValid(graph, i, j)) {
                    graph[i][j] = 1;
                    process(graph, i, j, count + 1);
                    graph[i][j] = 0;
                }
            }
        }
        max_people = Math.max(count, max_people);
    }

    public static boolean isValid(int[][] graph, int x, int y) {
        int m = graph.length;
        int n = graph[0].length;
        if (x - 1 >= 0 && graph[x - 1][y] == 1) return false;
        if (x + 1 < m && graph[x + 1][y] == 1) return false;
        if (y - 1 >= 0 && graph[x][y - 1] == 1) return false;
        if (y + 1 < n && graph[x][y + 1] == 1) return false;
        return true;
    }
}
