#include "bits/stdc++.h"

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int> &nums) {
        int n = nums.size();

        // 复制一份 nums
        vector<int> copy(nums.begin(), nums.end());
        nums.insert(nums.end(), copy.begin(), copy.end());

        vector<int> ans(n * 2, -1);

        stack<int> st;
        for (int i = 0; i < n * 2; i++) {
            while (!st.empty() && nums[st.top()] < nums[i]) {
                int idx = st.top();
                ans[idx] = nums[i];
                st.pop();
            }
            st.push(i);
        }

        // 剪切 ans 为原来的一半并返回
        ans.resize(n);
        return ans;
    }
};