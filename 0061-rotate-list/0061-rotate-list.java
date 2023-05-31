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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0 || head.next==null){
            return head;
        }
        int length = 0;
        
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(k==length){
            return head;
        }
        
        if(k<length){
            int len = length-k;
            temp = head;
            
            int ct = 0;
            ListNode prev = null;
            while(ct!=len){
                prev = temp;
                temp = temp.next;
                ct++;
            }
            
            prev.next = null;
            ListNode ans = temp;
            ListNode frog = ans;
            
            while(frog.next!=null){
                frog = frog.next;
            }
            frog.next = head;
            return ans;
        }else{
            int a = k%length;
            int len = length-a;
            if(a==0){
                return head;
            }
            temp = head;
            
            int ct = 0;
            ListNode prev = null;
            while(ct!=len){
                prev = temp;
                temp = temp.next;
                ct++;
            }
            
            prev.next = null;
            ListNode ans = temp;
            ListNode frog = ans;
            
            while(frog.next!=null){
                frog = frog.next;
            }
            frog.next = head;
            return ans;
        }
        
        // return head;
    }
}