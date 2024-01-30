/*
 * LC0704.cpp
 *
 *  Created on: 2023年12月31日
 *      Author: zh6ta
 */

#include "LC0704.h"

using std::cout;
using std::endl;

int LC0704::search(vector<int> &nums, int target) {
	int res = -1;

	if (nums.size() == 0) {
		return res;
	}

	int l = 0;
	int r = nums.size() - 1;

	if (target < nums[l] || nums[r] < target) {
		return res;
	}

	while (l <= r) {
		int mid = l + (r - l) / 2;
		if (target == nums[mid]) {
			return mid;
		} else if (target > nums[mid]) {
			l = mid + 1; // 不要忘记 +1
		} else if (target < nums[mid]) {
			r = mid - 1; // 不要忘记 -1
		}
	}

	return res;
}
