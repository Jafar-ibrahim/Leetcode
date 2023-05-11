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
        while(list1 != null && list2!= null){
            if(list1.val > list2.val){
                 k.next = new ListNode(list2.val);
                 k=k.next;
                 list2 = list2.next;
            }else if(list1.val <= list2.val){
                k.next = new ListNode(list1.val);
                k=k.next;
                list1 = list1.next;
            }
        }
        while(list1 != null){
            k.next = new ListNode(list1.val);
            k=k.next;
            list1 = list1.next;
        }
        while(list2 != null){
            k.next = new ListNode(list2.val);
            k=k.next;
            list2 = list2.next;
        }
        return answer.next;
    }
}