#include "utils/FileReader.h"
#include "LeetCode/LC0054.h"
#include "LeetCode/LC0059.h"
#include "LeetCode/LC0209.h"
#include "LeetCode/LC0027.h"
#include "LeetCode/LC0704.h"

#include <cstdint>
#include <array>

#define FILL(ret) func<(ret).size()>(ret)

template<size_t N>
void func(std::array<uint8_t, N> ret) {
	for (size_t i = 0; i < ret.size(); i++) {
		printf("%02X ", ret[i]);
	}
	std::cout << std::endl;
}

int main(int argc, char *argv[]) {

	{
		std::array<uint8_t, 1> tmp1 = { 0 };
		tmp1[0] = 0x22;
		std::array<uint8_t, 3> tmp2;
		tmp2[0] = 0x33;
		tmp2[1] = 0x21;
		tmp2[2] = 0x12;

		FILL(tmp1);
		FILL(tmp2);
	}

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

//	{
//		LC0027 solution;
//		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/numbers.txt";
//		vector<int> nums = fileReader.getNumbers(file_path);
//		int res = solution.removeElement(nums, 4);
//		cout << res << endl;
//	}

	{
		LC0704 solution;
		file_path = "D:/local_workshop/leetcode/cpp/src/inputs/numbers.txt";
		vector<int> nums = fileReader.getNumbers(file_path);
		int target = 2;
		cout << target << endl;
		int res = solution.search(nums, target);
		cout << res << endl;
	}

	return 0;
}
