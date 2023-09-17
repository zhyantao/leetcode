#include "bits/stdc++.h"

using namespace std;

typedef long long ll;
const int mod = 1e9 + 7;
const int N = 1000010;
const int INF = INT_MAX;
const int dx[]{0, 1, 0, -1, -1, -1, 1, 1};
const int dy[]{-1, 0, 1, 0, -1, 1, 1, -1};

ll dp[N];

int main()
{

    ifstream fin; // 读文件，相对路径是相对于可执行文件
    fin.open("input.txt", ios::in);

    if (!fin.is_open())
    {
        cout << "open file error" << endl;
    }
    else
    {
        cout << "open file success" << endl;
    }

    int n;
    fin >> n; // 读第一个数字

    // 读矩阵
    vector<vector<int>> matrix(n, vector<int>(n));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            fin >> matrix[i][j];
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }

    // 从控制台按行读取
    string line;
    getline(fin, line); // 【闭坑】吸收之前剩余的换行符
    while (getline(fin, line))
    {                             // 从控制台读取一行输入
        stringstream words(line); // 将读取的一行数据绑定到 words
        string word;              // 用于临时保存结果
        vector<int> nums;
        while (getline(words, word, ','))
        {
            nums.push_back(stoi(word)); // string -> int
        }

        // 处理逻辑 TODO
        for (int num : nums)
            cout << num << " ";
        cout << endl;
    }

    // 遍历 4 个方向
    int row = 10, col = 10; // 行数和列数
    int x = 0, y = 0;       // 当前位置
    for (int i = 0; i < 8; i++)
    {                       // 将 8 改为 4 即为 4 邻域
        int xx = x + dx[i]; // 下一步的坐标
        int yy = y + dy[i];

        // 越界条件
        if (xx < 0 || xx >= col || yy < 0 || yy >= row)
        {
            continue;
        }

        // 处理逻辑 TODO
    }
}
/* input.txt
2
5 1
2 3
0,1,2
2,2,3,4,8
 */
