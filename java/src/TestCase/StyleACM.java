package TestCase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// ACM 模式，类名必须为 Main
public class StyleACM {

    private static final int N = 707;
    private static final int INF = 0x3f3f3f3f;
    private static final int[] dx = new int[]{0, 1, 0, -1, -1, -1, 1, 1};
    private static final int[] dy = new int[]{-1, 0, 1, 0, -1, 1, 1, -1};
    private static int[] dp = new int[N];

    public static void main(String[] args) throws FileNotFoundException {
    	System.out.println(INF);
    	try {
			System.out.println(Arrays.asList(dp));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        System.out.println(n);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        in.nextLine(); // 吸收回车
        String line = in.nextLine();
        System.out.println(line);

        float f = in.nextFloat();
        System.out.printf("%.2f\n", f);

        // 遍历 4 个方向
        int row = 10, col = 10; // 行数和列数
        int x = 0, y = 0; // 当前位置
        for (int i = 0; i < 8; i++) { // 将 8 改为 4 即为 4 邻域
            int xx = x + dx[i]; // 下一步的坐标
            int yy = y + dy[i];

            // 越界条件
            if (xx < 0 || xx >= col || yy < 0 || yy >= row) {
                continue;
            }

            // 处理逻辑 TODO
            x++;
            y++;
        }
        
        System.out.println("all done!");
    }
}

/*
input.txt

2
1 2
Hello World!
3.1415926
*/

