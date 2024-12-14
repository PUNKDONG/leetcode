package treenode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treecode3
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
        TreeNode root = buildpreTree(values);
        TreeNode treeNode = invertTree(root);
        chenxubianli(treeNode);

    };
    public static void chenxubianli(TreeNode root){
    Queue<TreeNode> q=new LinkedList();
    q.offer(root);
    while(!q.isEmpty()){
        TreeNode poll = q.poll();
        System.out.println(poll.val);
        if(poll.left!=null)q.offer(poll.left);
        if(poll.right!=null)q.offer(poll.right);
    }

    }
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
    public static TreeNode invertTreeHelper(TreeNode root){
        TreeNode treeNode = invertTree(root);
        return  treeNode;
    }
    public  static  TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
}