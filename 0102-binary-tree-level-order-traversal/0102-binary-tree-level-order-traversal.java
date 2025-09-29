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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        helper(root,0);
        return res;
    }
    public void helper(TreeNode root,int lvl){
        if(root==null)
           return;
        if(res.size()==lvl){
            res.add(new ArrayList<>());
        }
        res.get(lvl).add(root.val);
        helper(root.left,lvl+1);
        helper(root.right,lvl+1);
    }
}