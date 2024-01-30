/*
 * ListNode.h
 *
 *  Created on: 2024年1月17日
 *      Author: zh6ta
 */

#ifndef SRC_MYSTRUCT_LISTNODE_H_
#define SRC_MYSTRUCT_LISTNODE_H_

// since C++11
#define NULL nullptr

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};

#endif /* SRC_MYSTRUCT_LISTNODE_H_ */
