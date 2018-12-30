/**
 * @author WallfacerRZD
 * @date 2018/12/30 13:48
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
public class ReverseLinkedList {
    private static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = head;
            ListNode curr = pre.next;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            head.next = null;
            return pre;
        }
    }

    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }

    /**
     * 本质和迭代方法一样, 只是赋值操作变为给函数传递参数.
     * 要想理解递归首先理解递归.
     */
    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            return reverseList(head, null);
        }

        private ListNode reverseList(ListNode head, ListNode newHead) {
            if (head == null) {
                return newHead;
            }
            ListNode next = head.next;
            head.next = newHead;
            return reverseList(next, head);
        }
    }
}
