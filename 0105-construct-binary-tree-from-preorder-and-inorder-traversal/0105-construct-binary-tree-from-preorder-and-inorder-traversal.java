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
    Map<Integer,Integer> cache;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        cache = new HashMap<>();
        preIdx=0;
        for(int i=0;i<inorder.length;i++){
            cache.put(inorder[i],i);
        }
       return  build(preorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int left,int right){
        if(right<left)
          return null;
        int rootVal =   preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = cache.get(rootVal);
        root.left = build(preorder,left,idx-1);
        root.right = build(preorder,idx+1,right);

        return root;
    }
}