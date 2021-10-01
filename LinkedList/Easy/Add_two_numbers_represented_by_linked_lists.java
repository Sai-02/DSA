
/*
 * Given two numbers represented by two linked lists of size N and M. The task
 * is to return a sum list. The sum list is a linked list representation of the
 * addition of two input numbers.
 * 
 * Example 1:
 * 
 * Input: N = 2 valueN[] = {4,5} M = 3 valueM[] = {3,4,5} Output: 3 9 0
 * Explanation: For the given two linked list (4 5) and (3 4 5), after adding
 * the two linked list resultant linked list will be (3 9 0). Example 2:
 * 
 * Input: N = 2 valueN[] = {6,3} M = 1 valueM[] = {7} Output: 7 0 Explanation:
 * For the given two linked list (6 3) and (7), after adding the two linked list
 * resultant linked list will be (7 0). Your Task: The task is to complete the
 * function addTwoLists() which has node reference of both the linked lists and
 * returns the head of the new list.
 * 
 * Expected Time Complexity: O(N) + O(M) Expected Auxiliary Space: O(N) + O(M)
 * 
 * Constraints: 1 <= N, M <= 5000
 */
// { Driver Code Starts
// driver

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
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

class Solution20 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        int carry = 0;
        ListNode temp1 = l1, temp2 = l2;
        while (temp1 != null && temp2 != null) {
            int sum = (temp1.val + temp2.val) + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            int sum = temp1.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            int sum = temp2.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
            temp2 = temp2.next;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }
        return reverse(dummyNode.next);

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}