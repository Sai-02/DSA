/**
 * You are given the head of a linked list.
 * 
 * Remove every node which has a node with a greater value anywhere to the right
 * side of it.
 * 
 * Return the head of the modified linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [5,2,13,3,8]
 * Output: [13,8]
 * Explanation: The nodes that should be removed are 5, 2 and 3.
 * - Node 13 is to the right of node 5.
 * - Node 13 is to the right of node 2.
 * - Node 8 is to the right of node 3.
 * Example 2:
 * 
 * Input: head = [1,1,1,1]
 * Output: [1,1,1,1]
 * Explanation: Every node has value 1, so no nodes are removed.
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the given list is in the range [1, 105].
 * 1 <= Node.val <= 105
 * Accepted
 * 54,626
 * Submissions
 * 83,036
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null)
            return head;
        head = reverse(head);
        ListNode prev = head, curr = head;
        while (curr != null) {
            if (curr.val < prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;

        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}