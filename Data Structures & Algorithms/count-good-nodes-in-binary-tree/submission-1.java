/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int answer = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return answer;     
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        if (root.val >= val) {
            answer++;
            val = root.val;
        }

        dfs(root.left, val);
        dfs(root.right, val);
    }
}
