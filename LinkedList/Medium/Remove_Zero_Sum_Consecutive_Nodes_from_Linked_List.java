
/**
 * Given the head of a linked list, we repeatedly delete consecutive sequences
 * of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list. You may return any
 * such answer.
 * 
 * 
 * 
 * (Note that in the examples below, all sequences are serializations of
 * ListNode objects.)
 * 
 * Example 1:
 * 
 * Input: head = [1,2,-3,3,1] Output: [3,1] Note: The answer [1,2,1] would also
 * be accepted. Example 2:
 * 
 * Input: head = [1,2,3,-3,4] Output: [1,2,4] Example 3:
 * 
 * Input: head = [1,2,3,-3,-2] Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The given linked list will contain between 1 and 1000 nodes. Each node in the
 * linked list has -1000 <= node.val <= 1000. Accepted 29,976 Submissions 71,354
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
import java.util.*;

class Solution19 {
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

    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        HashMap<Integer, ListNode> hm = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = dummyNode;

        while (temp != null) {
            sum += temp.val;
            hm.put(sum, temp);
            temp = temp.next;
        }
        sum = 0;
        temp = dummyNode;
        while (temp != null) {
            sum += temp.val;
            temp.next = hm.get(sum).next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}