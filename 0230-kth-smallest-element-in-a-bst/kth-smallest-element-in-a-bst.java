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

        PriorityQueue<Integer> q = new PriorityQueue<>();
        inorder(root,q);
        int temp = -1;
        while(k > 0){
            temp = q.poll();
            k--;
        }
        return temp;


        
    }

    void inorder(TreeNode root, PriorityQueue<Integer> q){
        if(root == null) return;
        inorder(root.left, q);
        q.offer(root.val);
        inorder(root.right, q);
        return;

    }
}