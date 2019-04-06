/**
 * leetcode 第203题
 */


public class Solution {


    public ListNode removeElements(ListNode head, int val) {

        ListNode temp = new ListNode(0);
        while(head!=null && head.val==val){
            if(head.val == val){
                temp = head;
                head = head.next;
                temp.next = null;
            }
        }
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;

        while(prev.next != null){
            if(prev.next.val==val){
                temp = prev.next;
                prev.next = prev.next.next;
                temp.next = null;
                continue;
            }
            prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head,6);
        System.out.println(res);
    }
}
