#include "LeetCode/LC0054.h"
#include "LeetCode/LC0059.h"
#include "tools/Handler.h"

int main(int argc, char *argv[]) {
//	Handler handler;

//	LC0054 solution;
//
//	string file_path;
//	vector<vector<int>> matrix;
//	vector<int> res;
//
//	file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix1.txt";
//	matrix = handler.handle_matrix(file_path);
//	res = solution.spiralOrder(matrix);
//	for (const auto &t : res)
//		cout << t << " ";
//	cout << endl;
//
//	file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix2.txt";
//	matrix = handler.handle_matrix(file_path);
//	res = solution.spiralOrder(matrix);
//	for (const auto &t : res)
//		cout << t << " ";
//	cout << endl;
//
//	file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix3.txt";
//	matrix = handler.handle_matrix(file_path);
//	res = solution.spiralOrder(matrix);
//	for (const auto &t : res)
//		cout << t << " ";
//	cout << endl;
//
//	file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix4.txt";
//	matrix = handler.handle_matrix(file_path);
//	res = solution.spiralOrder(matrix);
//	for (const auto &t : res)
//		cout << t << " ";
//	cout << endl;

	LC0059 solution0059;
	vector<vector<int>> res0059 = solution0059.generateMatrix(3);
	for (const auto &row : res0059) {
		for (const auto &col : row) {
			cout << col << " ";
		}
		cout << endl;
	}

	return 0;
}
