#include "LeetCode/LC0054.h"
#include "tools/Handler.h"

int main() {
	Handler handler;
	LC0054 solution;

	string file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix1.txt";
	vector<vector<int>> matrix = handler.handle_matrix(file_path);
	vector<int> res = solution.spiralOrder(matrix);

	for (const auto &t : res) {
		cout << t << " ";
	}
	cout << endl;

	return 0;
}
