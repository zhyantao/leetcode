/*
 * LC0027.cpp
 *
 *  Created on: 2023年12月31日
 *      Author: zh6ta
 */

#include "LC0027.h"

int LC0027::removeElement(vector<int> &nums, int val) {
	int res = -1;

	int l = 0;
	int r = nums.size() - 1;

	// TODO 这几个 if 可以简化
	while (l <= r) {
		if (nums[l] == val && nums[r] != val) {
			nums[l] = nums[r];
			r--;
			l++;
		} else if (nums[l] == val && nums[r] == val) {
			r--;
		} else if (nums[l] != val && nums[r] == val) {
			r--;
			l++;
		} else if (nums[l] != val && nums[r] != val) {
			l++;
		}
	}

	res = l;
	return res;
}
