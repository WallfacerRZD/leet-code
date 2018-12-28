/**
 * @author WallfacerRZD
 * @date 2018/12/28 13:39
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dump = new ListNode(-1);
            dump.next = head;
            ListNode pre = dump;
            while (pre.next != null) {
                if (pre.next.val == val) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
            return dump.next;
        }
    }

    /**
     * 道理我都懂, 但是怎么写递归呢?
     */
    static class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}
