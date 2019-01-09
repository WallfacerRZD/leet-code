import java.util.*;

/**
 * @author WallfacerRZD
 * @date 2019/1/9 11:55
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            boolean leftToRight = true;
            while (!stack.isEmpty()) {
                List<Integer> subList = new ArrayList<>();
                Queue<TreeNode> queue = new LinkedList<>();
                int level = stack.size();
                for (int i = 0; i < level; i++) {
                    queue.offer(stack.pop());
                }
                while (!queue.isEmpty()) {
                    if (leftToRight) {
                        if (queue.peek().left != null) {
                            stack.push(queue.peek().left);
                        }
                        if (queue.peek().right != null) {
                            stack.push(queue.peek().right);
                        }
                    } else {
                        if (queue.peek().right != null) {
                            stack.push(queue.peek().right);
                        }
                        if (queue.peek().left != null) {
                            stack.push(queue.peek().left);
                        }
                    }
                    subList.add(queue.poll().val);
                }
                leftToRight = !leftToRight;
                result.add(subList);
            }
            return result;
        }
    }

    /**
     * cool!!
     */
    class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            travel(root, result, 0);
            return result;
        }

        private void travel(TreeNode current, List<List<Integer>> result, int level) {
            if (current == null) {
                return;
            }
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            boolean isEvenLevel = level % 2 ==0;
            if (isEvenLevel) {
                result.get(level).add(current.val);
            } else {
                result.get(level).add(0, current.val);
            }
            travel(current.left, result, level + 1);
            travel(current.right, result, level + 1);
        }
    }
}
