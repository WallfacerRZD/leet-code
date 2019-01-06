import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WallfacerRZD
 * @date 2019/1/6 16:42
 */
public class BinaryTreeInorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }

    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pointer = root;
            while (pointer != null || !stack.isEmpty()) {
                while (pointer != null) {
                    stack.add(pointer);
                    pointer = pointer.left;
                }
                pointer = stack.pop();
                result.add(pointer.val);
                pointer = pointer.right;
            }
            return result;
        }
    }
}
