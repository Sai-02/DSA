/**
 * 
 * Given the head of a singly linked list where elements are sorted in ascending
 * order, convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [-10,-3,0,5,9] Output: [0,-3,9,-10,null,5] Explanation: One
 * possible answer is [0,-3,9,-10,null,5], which represents the shown height
 * balanced BST. Example 2:
 * 
 * Input: head = [] Output: [] Example 3:
 * 
 * Input: head = [0] Output: [0] Example 4:
 * 
 * Input: head = [1,3] Output: [3,1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in head is in the range [0, 2 * 104]. -105 <= Node.val <=
 * 105 Accepted 332,590 Submissions 622,205
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  ===========================================================================================
// 
// Question Link :https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// 
// ===========================================================================================
class Solution22 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        if(head.next==null){
            TreeNode root=new TreeNode(head.val);
            return root;
        }
        
        ListNode slow=head,fast=head,prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
              fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        prev.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow.next);
        return root;
    }
}