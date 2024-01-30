#include "FileReader.h"
#include "LC0054.h"
#include "LC0059.h"
#include "LC0209.h"
#include "LC0027.h"
#include "LC0704.h"

int main(int argc, char *argv[]) {
	FileReader fileReader;
	string file_path;

	std::cout << "hello world" << std::endl;

//	{
//		LC0054 solution;
//		vector<vector<int>> matrix;
//
//		vector<int> res;
//		file_path = "inputs/matrix1.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//
//		file_path = "inputs/matrix2.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//
//		file_path = "inputs/matrix3.txt";
//		matrix = fileReader.getMatrix(file_path);
//		res = solution.spiralOrder(matrix);
//		for (const auto &t : res)
//			cout << t << " ";
//		cout << endl;
//
//		file_path = "inputs/matrix4.txt";
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
//		file_path = "inputs/numbers.txt";
//		vector<int> nums = fileReader.getNumbers(file_path);
//		int res = solution.minSubArrayLen(697439, nums);
//		cout << res << endl;
//	}

//	{
//		LC0027 solution;
//		file_path = "inputs/numbers.txt";
//		vector<int> nums = fileReader.getNumbers(file_path);
//		int res = solution.removeElement(nums, 4);
//		cout << res << endl;
//	}

	{
		LC0704 solution;
		file_path = "inputs/numbers.txt";
		vector<int> nums = fileReader.getNumbers(file_path);
		int target = 2;
		cout << target<< endl;
		int res = solution.search(nums, target);
		cout << res << endl;
	}

	return 0;
}
