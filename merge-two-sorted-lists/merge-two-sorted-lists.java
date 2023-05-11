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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode answer = new ListNode(-1);
        ListNode k =answer;
        while(i != null && j!= null){
            if(i.val > j.val){
                 k.next = new ListNode(j.val);
                 k=k.next;
                 j = j.next;
            }else if(i.val <= j.val){
                k.next = new ListNode(i.val);
                k=k.next;
                i = i.next;
            }
        }
        while(i != null){
            k.next = new ListNode(i.val);
            k=k.next;
            i = i.next;
        }
        while(j != null){
            k.next = new ListNode(j.val);
            k=k.next;
            j = j.next;
        }
        return answer.next;
    }
}