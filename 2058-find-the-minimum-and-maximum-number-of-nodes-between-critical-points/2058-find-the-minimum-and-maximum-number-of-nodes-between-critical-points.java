/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = -1; ans[1] = -1;
        if(head==null || head.next==null || head.next.next==null){
            return ans;
        }
        
        ListNode prev = head;
        ListNode temp = head.next;
        
        int max = 0, min = 0, minA = Integer.MAX_VALUE, maxA = Integer.MIN_VALUE;
        int ct = 2;
        while(temp.next!=null){
            if(((temp.val>prev.val && temp.val>temp.next.val) || (temp.val<prev.val && temp.val<temp.next.val)) && max==0){
                max = ct;
                min = ct;
            }else if((temp.val>prev.val && temp.val>temp.next.val) || (temp.val<prev.val && temp.val<temp.next.val)){
                minA = Math.min(minA, ct-min);
                maxA = Math.max(maxA, ct-max);
                min = ct;
            }
            
            prev = temp;
            temp = temp.next;
            ct++;
        }
        
        if(minA!=Integer.MAX_VALUE){
            ans[0] = minA;
        }
        if(maxA != Integer.MIN_VALUE){
            ans[1] = maxA;
        }
        return ans;
    }
}