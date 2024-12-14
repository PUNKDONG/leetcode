package treenode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treecode4
{
    static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val = val;};
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] values=s.substring(1,s.length()-1).split(",");
        TreeNode newroot = buildpreTree(values);
        boolean symmetric = isSymmetric(newroot);
        System.out.println(symmetric);


    };
    public static TreeNode buildpreTree(String[] values) {
        // 如果输入为空或首元素是 "null"，直接返回 null
      if(values.length==0||values[0].equals("null")) return null;
      TreeNode root=new TreeNode(Integer.parseInt(values[0]));
      Queue<TreeNode> q=new LinkedList<>();
      q.offer(root);
      int idx=1;
      while(!q.isEmpty()&&idx<values.length){
          TreeNode currentNode=q.poll();
          if(!values[idx].equals("null") ){
              currentNode.left=new TreeNode(Integer.parseInt(values[idx]));
              q.offer(currentNode.left);

          }
          idx++;
          if(idx<values.length&&!values[idx].equals("null") ){
              currentNode.right=new TreeNode(Integer.parseInt(values[idx]));
              q.offer(currentNode.right);
          }
          idx++;
      }
        return root;
    }
    public static boolean isSymmetric(TreeNode root) {
    return isSymmetricHelper(root.right,root.left);
    }
    public static boolean isSymmetricHelper(TreeNode t1,TreeNode t2) {
        if(t1==null&&t2==null)return true;
    if(t1==null||t2==null)return false;

    return t1.val==t2.val&&isSymmetricHelper(t1.left,t2.right)&&isSymmetricHelper(t1.right,t2.left);
    }
}