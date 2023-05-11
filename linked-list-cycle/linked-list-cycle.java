/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode fast = head.next , slow = head;
        while(fast!=null && fast.next!=null && slow != fast){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow == fast;
    }
}