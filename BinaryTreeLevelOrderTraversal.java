import java.util.*;

/**
 * @author WallfacerRZD
 * @date 2019/1/8 14:59
 */
public class BinaryTreeLevelOrderTraversal {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int level = queue.size();
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < level; i++) {
                    if (queue.peek().left != null) {
                        queue.offer(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.offer(queue.peek().right);
                    }
                    subList.add(queue.poll().val);
                }
                result.add(subList);
            }
            return result;
        }
    }
}
