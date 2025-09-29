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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
          return false;
        return helper(root,0,targetSum);
    }

    public boolean helper(TreeNode root,int currSum,int targetSum){
        if(root==null)
          return false;
        currSum += root.val;
        if(root.left==null && root.right==null)
          return currSum==targetSum ;
        
        return helper(root.left,currSum,targetSum) ||   helper(root.right,currSum,targetSum) ;
    }

}