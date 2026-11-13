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
    public void helper(List<List<Integer>> ans , int level , TreeNode root) {
        if (root == null) return ;
        if(level >= ans.size()){
            ans.add(new LinkedList<Integer>()) ;
        }
        ans.get(level).add(root.val) ;
        helper(ans , level+1 ,root.left) ;
        helper(ans , level+1 ,root.right) ;
        return ;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        helper(ans , 0 , root) ;
        return ans ;
    }
}
