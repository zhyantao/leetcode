#include "bits/stdc++.h"
#include "../MyStruct/ListNode.h"

using namespace std;

class Solution {
public:
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