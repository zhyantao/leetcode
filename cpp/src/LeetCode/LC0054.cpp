#include "LC0054.h"

vector<int> LC0054::spiralOrder(vector<vector<int>> &matrix) {
	vector<int> res;
	int m = matrix.size(); // number of rows
	int n = matrix[0].size(); // number of cols

	int row = 0;
	int col = 0;

	int start_row = 0;
	int start_col = 0;

	while (start_col <= n / 2 || start_row <= m / 2) {
		row = start_row;
		col = start_col;

		// 第一行（除去最后一个元素，左闭右开）
		for (; col < n - 1 - start_col; col++) {
			cout << row << "," << col << endl;
			res.push_back(matrix[row][col]);
		}

		// 最后一列（除去最后一个元素，左闭右开）
		for (; row < m - 1 - start_row; row++) {
			cout << row << "," << col << endl;
			res.push_back(matrix[row][col]);
		}

		// 最后一行（除去最后一个元素，左闭右开）
		for (; col > start_col; col--) {
			cout << row << "," << col << endl;
			res.push_back(matrix[row][col]);
		}

		// 第一列（除去最后一个元素，左闭右开）
		for (; row > start_row; row--) {
			cout << row << "," << col << endl;
			res.push_back(matrix[row][col]);
		}

		start_row++;
		start_col++;
	}

	return res;
}
