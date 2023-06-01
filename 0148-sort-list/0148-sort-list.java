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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode temp = head;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while(temp!=null){
            pq.add(temp.val);
            temp = temp.next;
        }
        
        ListNode pemp = head;
        while(pemp!=null){
            pemp.val = pq.poll();
            pemp = pemp.next;
        }
        
        return head;
    }
}