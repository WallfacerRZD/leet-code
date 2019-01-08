import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WallfacerRZD
 * @date 2019/1/8 13:30
 */
public class ValidateBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * too slow!
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> integers = new ArrayList<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                integers.add(p.val);
                p = p.right;
            }
            for (int i = 0; i + 1 < integers.size(); i++) {
                if (integers.get(i) >= integers.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                if (pre != null && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) {
                return true;
            }
            return isValidBST(root.left, minVal, root.val) &&
                    isValidBST(root.right, root.val, maxVal) &&
                    minVal < root.val && root.val < maxVal;
        }
    }
}
