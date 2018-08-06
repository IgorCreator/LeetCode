package easy;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = null;

        if(t2 == null && t1 != null){
            treeNode = t1;
        } else if(t1 == null && t2 != null ){
            treeNode = t2;
        } else if(t1 != null && t2 != null ){
            treeNode = new TreeNode(t1.val + t2.val);
            treeNode.right = insertingNode(t1.right, t2.right, treeNode.right);
            treeNode.left = insertingNode(t1.left, t2.left, treeNode.left);
        }

        return treeNode;
    }

    private TreeNode insertingNode(TreeNode node1, TreeNode node2, TreeNode treeNode) {
        if(node2 == null && node1 != null){
            treeNode = node1;
        } else if(node1 == null && node2 != null){
            treeNode = node2;
        } else if(node1 != null && node2 != null) {
            treeNode = mergeTrees(node1, node2);
        }
        return treeNode;
    }


    public TreeNode mergeTreesNotMineDecision(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /*Definition for a binary tree node.*/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

    }
}

