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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = new ListNode(-1);
        ListNode pemp = new ListNode(-1);
        ListNode curr = temp, ptr = pemp;
        
        while(head!=null){
            temp.next = head;
            head = head.next;
            if(head!=null){
                pemp.next = head;
                head = head.next;
                pemp = pemp.next;
            }
            temp = temp.next;
        }
        
        pemp.next = null;
        temp.next = ptr.next;
        return curr.next;
    }
}