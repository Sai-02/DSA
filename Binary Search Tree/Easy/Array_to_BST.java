/*
Given a sorted array. Convert it into a Height balanced Binary Search Tree (BST).
Height balanced BST means a binary tree in which the depth of the two subtrees of
 every node never differ by more than 1.

Example 1:

Input: nums = {1,2,3,4,5,6,7}
Ouput: {4,2,1,3,6,5,7}
Explanation: The possible answer is:
{4,2,1,3,6,5,7} which is the preorder
traversal of theheight balanced BST:
        4
       / \
      2   6
     / \  / \
    1   3 5  7
Your Task:
You don't need to read or print anything.
 Your task is to complete the function sortedArrayToBST()
  which takes nums as input paramater and 
  returns the preorder traversal of height balanced BST.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)
 */

//{Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Array_to_BST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for (int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;

    }
}

class Solution {
    ArrayList<Integer> order = new ArrayList<>();

    public int[] sortedArrayToBST(int[] nums) {
        Node root = solver(nums, 0, nums.length - 1);
        preorder(root);
        root = null;
        for (int i = 0; i < order.size(); i++) {
            nums[i] = order.get(i);
        }

        return nums;
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        order.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public Node solver(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node newNode = new Node(nums[mid]);
        newNode.left = solver(nums, start, mid - 1);
        newNode.right = solver(nums, mid + 1, end);
        return newNode;
    }
}