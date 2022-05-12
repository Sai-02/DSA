/**
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * 
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * Accepted
 * 703,924
 * Submissions
 * 1,218,883
 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)hm.put(inorder[i],i);
        return solver(hm,preorder,0,preorder.length-1);
    }
    public TreeNode solver(HashMap<Integer,Integer> hm,int[] preorder,int l,int r){
        if(l<0||r>=preorder.length||index>=preorder.length)return null;
        int inorderIndex=hm.get(preorder[index]);
        if(inorderIndex<l||inorderIndex>r)return null;
        TreeNode root=new TreeNode(preorder[index]);
        index++;
        root.left=solver(hm,preorder,l,inorderIndex-1);
        root.right=solver(hm,preorder,inorderIndex+1,r);
        return root;
    }
}