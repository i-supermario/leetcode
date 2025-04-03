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
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> q = new ArrayList<>();
        inorder(root,q);
        
        return q.get(k-1);


        
    }

    void inorder(TreeNode root, List<Integer> q){
        if(root == null) return;
        inorder(root.left, q);
        q.add(root.val);
        inorder(root.right, q);
        return;

    }
}