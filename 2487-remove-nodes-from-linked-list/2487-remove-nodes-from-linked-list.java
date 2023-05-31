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
    public ListNode removeNodes(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode temp = reverse(head);
        ListNode curr = temp;
        
        int max = temp.val;
        while(temp.next!=null){
            if(temp.next.val>=max){
                max = temp.next.val;
            }else{
                temp.next.val = -temp.next.val;
            }
            
            temp = temp.next;
        }
        
        ListNode ptr = reverse(curr);
        ListNode del = null, start = null;
        while(ptr!=null && ptr.val<0){
            ptr = ptr.next;
        }
        
        start = ptr;
        while(ptr!=null){
            int ct = 0;
            ListNode sept = null;
            while(ptr!=null && ptr.val<0){
                sept = ptr;
                ptr = ptr.next;
                ct++;
            }
            
            if(ct!=0){
                del.next = sept.next;
            }
            
            del = ptr;
            ptr = ptr.next;
        }
        
        return start;
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