/*
 * LC0059.cpp
 *
 *  Created on: 2023年12月27日
 *      Author: zh6ta
 */

#include "LC0059.h"

using std::cout;
using std::endl;

vector<vector<int>> LC0059::generateMatrix(int n) {
	int l = 0;
	int r = n - 1;
	int t = 0;
	int b = n - 1;

	vector<vector<int>> res(n, vector<int>(n));

	int num = 1;
	while (num <= n * n) {
		for (int i = l; i <= r; i++) {
			res[t][i] = num++;
		}
		t++; // 下移一行
		for (int i = t; i <= b; i++) {
			res[i][r] = num++;
		}
		r--;
		for (int i = r; i >= l; i--) {
			res[b][i] = num++;
		}
		b--;
		for (int i = b; i >= t; i--) {
			res[i][l] = num++;
		}
		l++;
	}

	return res;
}
