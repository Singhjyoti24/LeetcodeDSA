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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        
        while(temp!=null){
            ListNode curr = temp;
            int ct = 0;
            while(temp.next!=null && temp.next.val == curr.val){
                temp = temp.next;
                ct++;
            }
            
            if(ct!=0){
                curr.next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }
}