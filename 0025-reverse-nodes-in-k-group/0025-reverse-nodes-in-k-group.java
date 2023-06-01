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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null){
                return head;
            }
            temp=temp.next;
        }
        
        ListNode prevPtr = null, currPtr = head, nextPtr = null;
        int ct = 0;
        while(currPtr!=null && ct<k){
            nextPtr = currPtr.next;
            currPtr.next = prevPtr;
            prevPtr = currPtr;
            currPtr = nextPtr;
            ct++;
        }
        
        if(nextPtr!=null){
            head.next = reverseKGroup(nextPtr,k);
        }
        
        return prevPtr;
    }
        }