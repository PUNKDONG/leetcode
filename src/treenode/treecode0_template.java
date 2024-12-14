package treenode;

import java.util.*;
public class  treecode0_template{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}

    }
public static void main(String[]args){
    Scanner in=new Scanner(System.in);
    while(in.hasNextLine()){

        String line = in.nextLine();
        //重要
        if (line.trim().isEmpty()) {
            break;
        }
        String[] value = line.substring(1, line.length() - 1).split(",");
        // String[] value=line.split(" ");
        // String[] value=line.split(",");
        TreeNode treeNode = buildTree(value);
      /*  List<Integer> list = inorderTraversal(treeNode);
        for(Integer i:list){
            System.out.print(i+" ");
        }*/

    }

}

public  static TreeNode buildTree(String []value){
         if(value.length==0||value[0].equals("null") ){
             return null;
         }
         Queue<TreeNode> q=new LinkedList<>();
         TreeNode root =new TreeNode(Integer.parseInt(value[0]));
         q.offer(root);
         int index=1;
         while(!q.isEmpty()&&index<value.length){
             TreeNode currentnode=q.poll();
             if(!value[index].equals("null")){
                 currentnode.left=new TreeNode(Integer.parseInt(value[index]));
                 q.offer(currentnode.left);
             }
             index++;
             if(index<value.length&&!value[index].equals("null")){
                 currentnode.right=new TreeNode(Integer.parseInt(value[index]));
                 q.offer(currentnode.right);
             }
             index++;
         }
        return root;
}
    /*public static  List<Integer> inorderTraversal( TreeNode root) {
        List<Integer> result=new ArrayList<>();
        digui(root,result);
        return result;
    }*/
   /* public static void digui( TreeNode root, List<Integer> result){
        if(root==null)return ;
        digui(root.left,result);
        result.add(root.val );
        digui(root.right,result);
    }*/

}