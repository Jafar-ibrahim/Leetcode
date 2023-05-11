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
        if(head.next==null)return ;
        ListNode reversedHalf = reverseList(midNode(head));
        mergeHalves(head,reversedHalf);
    }
    public void mergeHalves(ListNode node1 , ListNode node2){
        ListNode i = node1 , j =node2;
        while(i.next!= null && j != null){
            node2=j;
            j=j.next;
            node2.next=i.next;
            i.next=node2;
            i=i.next.next;
        }
        if(j!=null)
            i.next = j;

    }
    public ListNode midNode(ListNode head){
        ListNode fast = head.next.next , slow = head;
        while(fast != null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next=null;
        return temp;
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode curr = head , prev=null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
}