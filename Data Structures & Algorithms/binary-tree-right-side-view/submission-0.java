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
    List<Integer> answer = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // 해당 depth에서 제일 바깥에 있는 놈을 찾기
        dfs(root, 0);
        return answer;        
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (answer.size() == depth) {
            answer.add(root.val);
        } else {
            answer.set(depth, Math.max(answer.get(depth), root.val));
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
