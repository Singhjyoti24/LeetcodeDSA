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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        if(root1==null && root2==null){
            return ans;
        }
       
        if(root1!=null){
            helper(root1, ans);
        }
        if(root2!=null){
            helper(root2, ans);
        }
        
        Collections.sort(ans);
        return ans;
    }
    
    public void helper(TreeNode root, List<Integer> ans){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
            
            if(node.left!=null){
                q.add(node.left);
            }
            
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }
}