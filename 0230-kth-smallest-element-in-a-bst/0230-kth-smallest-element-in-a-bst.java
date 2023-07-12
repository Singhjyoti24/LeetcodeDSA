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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        helper(root, pq, k);
        for(int i=1;i<k;i++){
            pq.poll();
        }
        return pq.peek();
    }
    
    public void helper(TreeNode root, PriorityQueue<Integer> pq, int k){
        if(root==null){
            return;
        }
        
        helper(root.left, pq, k);
        pq.add(root.val);
        helper(root.right, pq, k);
    }
}