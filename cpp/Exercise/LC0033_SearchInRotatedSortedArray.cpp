#include "bits/stdc++.h"

using namespace std;

class Solution {
public:
    int search(vector<int> &nums, int target) {
        int left = 0, right = nums.size() - 1;

        // 移动左右指针
        while (left < right) {
            int mid = (left + right) / 2;
            // 异或操作：1 个为真或三个为真，结果为真
            if (nums[0] > target ^ nums[0] > nums[mid] ^ target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left == right && nums[left] == target ? left : -1;
    }
};