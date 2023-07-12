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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> arr = new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode node = q.poll();
                arr.add(node.val);
                if(node.left!=null){
                q.add(node.left);
                }
            
                if(node.right!=null){
                q.add(node.right);
                }
            }
            
            if(flag==0){
                ans.add(arr);
                flag = 1;
            }else{
                Collections.reverse(arr);
                flag = 0;
                ans.add(arr);
            }
        }
        return ans;
    }
}