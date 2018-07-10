/**
 * @author WallfacerRZD
 * @date 2018/7/10 16:58
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RotateList {
    /**
     * 将链表连成一个环, 然后在适当的位置断开.
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int nodeCount = 1;
            ListNode p = head;
            ListNode newHead = head;
            while (p.next != null) {
                nodeCount++;
                p = p.next;
            }
            p.next = head;
            int moveCount = nodeCount - (k % nodeCount) - 1;
            for (int i = 0; i < moveCount; i++) {
                newHead = newHead.next;
            }
            ListNode temp = newHead.next;
            newHead.next = null;
            newHead = temp;
            return newHead;
        }
    }
}
