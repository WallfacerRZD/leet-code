/**
 * @author WallfacerRZD
 * @date 2019/1/3 11:34
 */
public class PalindromeLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow = reverseLinkedList(slow);
            while (head != null && slow != null) {
                if (head.val != slow.val) {
                    return false;
                }
                head = head.next;
                slow = slow.next;
            }
            return true;
        }

        private ListNode reverseLinkedList(ListNode head) {
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
}
