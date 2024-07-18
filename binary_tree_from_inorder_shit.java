public class binary_tree_from_inorder_shit {

    
    public static void main(String[] args){
        int pointer=0;
        int[] preOrder={3,9,20,15,7};
        int len = preOrder.length;
        TreeNode root=new TreeNode(preOrder[pointer]);
        solve()


    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val) {this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
