/**
 * Given the head of a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two 
partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
Accepted
302,142
Submissions
653,038
Seen this question in a real interview before?
 */

//  =====================================================================
// 
// Question link:https://leetcode.com/problems/partition-list/
// 
// ========================================================================

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution21 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummyNode = new ListNode(0);
        ListNode largeDummyNode = new ListNode(0);
        ListNode small = smallDummyNode, large = largeDummyNode;
        while (head != null) {
            if (head.val >= x) {
                large.next = head;
                head = head.next;
                large = large.next;
            } else {
                small.next = head;
                ;
                head = head.next;
                small = small.next;
            }

        }
        large.next = null;
        small.next = largeDummyNode.next;
        return smallDummyNode.next;
    }
}