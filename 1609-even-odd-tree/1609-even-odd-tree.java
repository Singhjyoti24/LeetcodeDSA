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
    public boolean isEvenOddTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return true;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0;
        
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=1;i<=size;i++){
                TreeNode node = q.poll();
                ans.add(node.val);
                
                if(node.left!=null){
                q.add(node.left);
                }
            
                if(node.right!=null){
                q.add(node.right);
                }
            }
            
            if(flag==0){
                if(ans.get(0)%2==0){
                    return false;
                }
                for(int i=0;i<ans.size()-1;i++){
                    if(ans.get(i)%2==0 || ans.get(i+1)%2==0){
                        return false;
                    }else if(ans.get(i)>=ans.get(i+1)){
                        return false;
                    }
                }
                flag = 1;
            }else{
                if(ans.get(0)%2!=0){
                    return false;
                }
                for(int i=0;i<ans.size()-1;i++){
                    if(ans.get(i)%2!=0 || ans.get(i+1)%2!=0){
                        return false;
                    }else if(ans.get(i)<=ans.get(i+1)){
                        return false;
                    }
                }
                flag = 0;
            }
            ans = new ArrayList<>();
        }
        
        return true;
    }
}