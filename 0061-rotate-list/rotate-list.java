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

        if(head == null) return head;
        

        ListNode base = new ListNode();
        base.next = head;

        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }

        ListNode rotatedHead = base;
        int i = 0;

        temp = base;
        k = k % len;

        while(i <= k){
            temp = temp.next;
            i++;
        }

        // Move rotatedHead to node before shifting nodes

        while(temp != null){
            temp = temp.next;
            rotatedHead = rotatedHead.next;
        }

        // Append shifted nodes to start

        base.next = rotatedHead.next;

        // Cut original link to shifted nodes
        rotatedHead.next = null;

        rotatedHead = base;

        // Add rest of the nodes

        while(rotatedHead.next != null){
            rotatedHead = rotatedHead.next;
        }
        rotatedHead.next = head;

        return base.next;


        

    }
}