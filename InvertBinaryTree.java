import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WallfacerRZD
 * @date 2019/1/1 11:36
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class InvertBinaryTree {

     private static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(right);
            return root;
        }
    }

    static class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return  null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                TreeNode tempNode = node.left;
                node.left = node.right;
                node.right = tempNode;
            }
            return root;
        }
    }
}
