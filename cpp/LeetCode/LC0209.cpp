/*
 * LC0209.cpp
 *
 *  Created on: 2023年12月28日
 *      Author: zh6ta
 */

#include "LC0209.h"

using std::cout;
using std::endl;

int LC0209::minSubArrayLen(int target, vector<int> &nums) {
	int res = INT_MAX;
	int n = nums.size();

	if (n == 0) {
		return 0;
	}

	// TODO 去掉前缀和，可将空间复杂度降为 O(1)
	// 构造前缀和数组
	vector<int> preSum(n + 1);
	preSum[0] = 0;
	for (int i = 1; i <= n; i++) {
		preSum[i] = preSum[i - 1] + nums[i - 1];
	}

	// 滑动窗口（两层循环，外层循环一直走，满足条件后内层循环开始走）
	int i = 0;
	for (int j = 0; j <= n; j++) {
		int sum = preSum[j] - preSum[i];
		while (sum >= target) {
			int d = j - i;
			res = d < res ? d : res;
			i++;
			sum = preSum[j] - preSum[i];
		}
	}

	return res == INT_MAX ? 0 : res;
}
