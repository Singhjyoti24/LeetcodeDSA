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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode ans = new ListNode(-1);
        ListNode arr = ans;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            int rem = sum%10;
            carry = sum/10;
            
            ListNode temp = new ListNode(rem);
            ans.next = temp;
            ans = ans.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1!=null){
            int sum = l1.val+carry;
            int rem = sum%10;
            carry = sum/10;
            
            ListNode temp = new ListNode(rem);
            ans.next = temp;
            ans = ans.next;
            
            l1 = l1.next;
        }
        
        while(l2!=null){
            int sum = l2.val+carry;
            int rem = sum%10;
            carry = sum/10;
            
            ListNode temp = new ListNode(rem);
            ans.next = temp;
            ans = ans.next;
            
            l2 = l2.next;
        }
        
        if(carry!=0){
            ListNode temp = new ListNode(carry);
            ans.next = temp;
            ans = ans.next;
        }
        
        return arr.next;
    }
}