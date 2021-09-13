/**
 * Problem Link :https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

// ===========================================
//
// Solution in two iterations
//
// ============================================
class Solution10 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        n = getSize(head) - n;
        if (n == 0) {
            head = head.next;
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while (temp != null) {
            if (count == n) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            count++;
        }
        return head;

    }

    public int getSize(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }
}

// ===============================================
//
// Solution in One Iteration Using Two Pointers
//
// ==============================================
class Solution120 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = head, slow = start;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;

    }
}