#include "LC0054.h"

vector<int> LC0054::spiralOrder(vector<vector<int>> &matrix) {
	vector<int> res;

	if (matrix.empty()) {
		return res;
	}

	int u = 0; // 上边界
	int d = matrix.size() - 1; // 下边界
	int l = 0; // 左边界
	int r = matrix[0].size() - 1; // 右边界

	while (true) {
		for (int i = l; i <= r; i++) {
			res.push_back(matrix[u][i]);
		}

		if (++u > d) {
			break;
		}

		for (int i = u; i <= d; ++i) {
			res.push_back(matrix[i][r]);
		}

		if (--r < l) {
			break;
		}

		for (int i = r; i >= l; --i) {
			res.push_back(matrix[d][i]);
		}

		if (--d < u) {
			break;
		}

		for (int i = d; i >= u; --i) {
			res.push_back(matrix[i][l]);
		}

		if (++l > r) {
			break;
		}
	}

	return res;
}
