/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public ListNode getIntersectionNode(ListNode list1, ListNode list2) {
        int len1 = length(list1);
        int len2 = length(list2);

        int d = 0;
        ListNode temp = list1, pemp = list2;
        if(len1>len2){
            d = len1-len2;
            temp = list1;
            pemp = list2;
        }else{
            d = len2-len1;
            temp = list2;
            pemp = list1;
        }
        
        while(d!=0){
            temp = temp.next;
            d--;
        }

        while(temp!=pemp){
            temp = temp.next;
            pemp = pemp.next;
        }

        return temp;
    }

    public int length(ListNode head){
        ListNode temp = head;

        int cnt = 0;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}