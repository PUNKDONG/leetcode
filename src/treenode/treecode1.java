package treenode;

import java.util.*;
public class treecode1
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
        TreeNode root = buildTree(values);
        List<Integer> result = inorderTraversal(root);
        for (int val : result) {
            System.out.print(val + " ");
        }

    };
    public static TreeNode buildTree(String[] values) {
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


    public static  List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        digui(root,result);
        return result;
    }
    public static void digui(TreeNode root,List<Integer> result){
        if(root==null)return ;
        digui(root.left,result);
        result.add(root.val );
        digui(root.right,result);
    }
}
