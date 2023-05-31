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

    ListNode ptr = null;
    int ct = 0;
    public Solution(ListNode head) {
        ListNode temp = head;
        ptr = head;
        while(temp!=null){
            ct++;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        int min = 1, max = ct;
        int ran = (int)(Math.random()*(max-min+1)+min);  
        
        ListNode red = ptr;
        int pt = 0;
        while(pt!=ran){
            pt++;
            if(pt==ran){
                return red.val;
            }
            red = red.next;
        }
        
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */