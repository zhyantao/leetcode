#include "bits/stdc++.h"
#include "../MyStruct/ListNode.h"

using namespace std;

class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.size() == 0) {
            return nullptr;
        }

        // 先合并两个，再合并其他
        int n = lists.size();
        ListNode *ans = nullptr;
        for (int i = 0; i < n; i++) {
            ans = mergeTwoLists(ans, lists.at(i));
        }

        return ans;
    }

    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {

        ListNode *p = new ListNode(-1);
        ListNode *dummy = p;

        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val < list2->val) {
                p->next = list1;
                list1 = list1->next;
            } else {
                p->next = list2;
                list2 = list2->next;
            }
            p = p->next;
        }

        if (list1 != nullptr) {
            p->next = list1;
        }

        if (list2 != nullptr) {
            p->next = list2;
        }

        return dummy->next;
    }
};