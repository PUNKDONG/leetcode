package treenode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treecode5
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
        int i = diameterOfBinaryTree(newroot);
        System.out.println(i);

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
    public static int diameterOfBinaryTree(TreeNode root) {
        int max[]={0};
        maxheight(root,max);
        return max[0];
    }

    public static  int maxheight(TreeNode root,int []max){
        if(root==null)return 0;
        int left=maxheight(root.left,max)  ;
        int right=maxheight(root.right,max) ;
        max[0]=Math.max(left+right,max[0]);
        return Math.max(left,right)+1;
    }

}