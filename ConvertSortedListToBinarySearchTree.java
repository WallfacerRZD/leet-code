/**
 * @author WallfacerRZD
 * @date 2019/1/10 11:40
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class ConvertSortedListToBinarySearchTree {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode( int x) {
            this.val = x;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 中序遍历, 构建二叉树
     * 用快慢指针寻找链表的中间节点(二叉树的根)
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return helper(head, null);
        }

        private TreeNode helper(ListNode head, ListNode tail) {
            if (head == tail) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != tail && fast.next.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = helper(head, slow);
            root.right = helper(slow.next, tail);
            return root;
        }
    }
}
