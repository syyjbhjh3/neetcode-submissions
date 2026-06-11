class Solution {
    public boolean isBalanced(TreeNode root) {
        // 1. 빈 트리는 항상 균형 트리입니다.
        if (root == null) return true;

        // 2. 현재 노드의 왼쪽, 오른쪽 서브트리 높이를 구합니다.
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // 3. 조건 체크:
        //    - 현재 노드의 왼쪽/오른쪽 높이 차이가 1 이하이고 (Math.abs)
        //    - 왼쪽 서브트리도 내부적으로 균형이 잡혀있어야 하고 (재귀)
        //    - 오른쪽 서브트리도 내부적으로 균형이 잡혀있어야 합니다. (재귀)
        return Math.abs(leftHeight - rightHeight) <= 1 
               && isBalanced(root.left) 
               && isBalanced(root.right);
    }

    // 트리의 높이를 구하는 헬퍼 함수
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}