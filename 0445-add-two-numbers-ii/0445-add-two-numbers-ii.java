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
    public ListNode addTwoNumbers(ListNode l11, ListNode l22) {
        int carry = 0;
        
        ListNode l1 = reverse(l11);
        ListNode l2 = reverse(l22);
        
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
        
        ListNode prf = arr;
        ListNode srf = prf.next;
        prf.next = null;
        ListNode phil = reverse(srf);
        return phil;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prevPtr = null, currPtr = head, nextPtr;
        
        while(currPtr!=null){
            nextPtr = currPtr.next;
            currPtr.next = prevPtr;
            prevPtr = currPtr;
            currPtr = nextPtr;
        }
        return prevPtr;
    }
}