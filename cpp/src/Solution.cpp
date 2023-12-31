#include "utils/FileReader.h"
#include "LeetCode/LC0054.h"
#include "LeetCode/LC0059.h"
#include "LeetCode/LC0209.h"
#include "LeetCode/LC0027.h"

int main(int argc, char *argv[]) {
	FileReader fileReader;
	string file_path;

//	{
//		LC0054 solution;
//		vector<vector<int>> matrix;
//
//		vector<int> res;
//		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix1.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//
//		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix2.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//
//		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix3.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//
//		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/matrix4.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//	}
//
//	{
//		LC0059 solution;
//		vector<vector<int>> res = solution.generateMatrix(3);
//		for (const auto &row : res) {
//			for (const auto &col : row) {
//				cout << col << " ";
//			}
//			cout << endl;
//		}
//	}
//
//	{
//		LC0209 solution;
//		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/numbers.txt";
//		vector<int> nums = fileReader.getNumbers(file_path);
//		int res = solution.minSubArrayLen(697439, nums);
//		cout << res << endl;
//	}

	{
		LC0027 solution;
		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/numbers.txt";
		vector<int> nums = fileReader.getNumbers(file_path);
		int res = solution.removeElement(nums, 4);
		cout << res << endl;
	}

	return 0;
}
