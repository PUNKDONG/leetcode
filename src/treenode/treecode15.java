 package treenode;
import com.sun.source.tree.Tree;

import java.util.*;
class treecode15{
    static class TreeNode{
        int val;
        TreeNode left;
       TreeNode right;
       TreeNode(int x){this.val=x;}
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if (s.isEmpty()) break; // 读取树的数组表示
            int pp = Integer.parseInt(sc.nextLine()); // 读取 p 的值
            int qq = Integer.parseInt(sc.nextLine()); // 读取 q 的值
            String[] split = s.substring(1, s.length() - 1).split(",");
            TreeNode root = buildtree(split);
            TreeNode p=new TreeNode(pp );
            TreeNode q=new TreeNode(qq);
            TreeNode treeNode = lowestCommonAncestor(root, p, q);
            System.out.println(treeNode.val);
        }
        sc.close();


    }
    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[1];
        result[0]=new TreeNode(0);
        helper(root,p,q,result);
        return result[0];
    }
    public static boolean helper(TreeNode root,TreeNode p, TreeNode q,TreeNode []result){
        if(root==null)return false;
        boolean left=helper(root.left,p,q,result);
        boolean right=helper(root.right,p,q,result);
        boolean now=(root.val==q.val)||(root.val==p.val);
        if((left&&right)|| now&&(left||right) ){
            result[0]=root;
        }
        return left||right||now;

    }
    public static TreeNode buildtree(String []nums){
        if(nums.length==0||nums[0].equals("null")||nums[0].equals(""))return null;
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(nums[0]) );
        q.offer(root);
        int index=1;
        while(index<nums.length&&!q.isEmpty()){
            TreeNode poll = q.poll();
            if(!nums[index].equals("null")){
                poll.left=new TreeNode(Integer.parseInt(nums[index]));
                q.offer(poll.left);
            }
            index++;
            if(index<nums.length&&!nums[index].equals("null")){
                poll.right=new TreeNode(Integer.parseInt(nums[index]));
                q.offer(poll.right);
            }
            index++;

        }
        return root;
    }

}
