#include "bits/stdc++.h"

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElement(vector<int> &nums1, vector<int> &nums2) {
        int n = nums2.size();
        vector<int> mono(n);
        deque<int> deque;
        unordered_map<int, int> map;
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.empty() && nums2[deque.back()] < nums2[i]) {
                deque.pop_back();
            }
            mono[i] = deque.empty() ? -1 : nums2[deque.back()];
            deque.push_back(i); // 压入下标
            map.insert({nums2[i], mono[i]});
        }

        vector<int> ans(nums1.size());
        for (int i = 0; i < nums1.size(); i++) {
            ans[i] = map.at(nums1[i]);
        }
        return ans;
    }
};

int main() {

    ifstream fin; // 读文件，相对路径是相对于可执行文件
    fin.open("../input.txt", ios::in);

    string line1;
    getline(fin, line1);
    istringstream words1(line1);
    vector<int> nums1;
    int word1;
    while (words1 >> word1) {
        nums1.push_back(word1);
    }

    string line2;
    getline(fin, line2);
    istringstream words2(line2);
    vector<int> nums2;
    int word2;
    while (words2 >> word2) {
        nums2.push_back(word2);
    }

    auto solution = new Solution();
    vector<int> ans = solution->nextGreaterElement(nums1, nums2);
    for (int an: ans) {
        cout << an << " ";
    }
    cout << endl;
}