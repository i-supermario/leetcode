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
    public void reorderList(ListNode head) {

        if(head == null) return ;

        // Halfway

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode rightHalf = slow.next;
        slow.next = null;

        // Reverse second half

        ListNode prev = null;
        ListNode curr = rightHalf;
        ListNode next = null;

        while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        ListNode head2 = prev;

        // Join two lists

        while(head != null && prev != null){

            ListNode temp = head.next, temp1 = prev.next;
            head.next = prev;
            prev.next = temp;
            head = temp;
            prev = temp1;

        }

        return;
        
    }
}