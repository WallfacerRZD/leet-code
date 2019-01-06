/**
 * @author WallfacerRZD
 * @date 2019/1/6 14:44
 */
public class ReverseLinkedListII {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * 别问
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }
            ListNode start = pre.next;
            ListNode next = start.next;
            for (int i = 0; i < n - m; i++) {
                start.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = start.next;
            }
            return dummy.next;
        }
    }
}
