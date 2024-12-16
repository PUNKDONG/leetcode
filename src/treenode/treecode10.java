package treenode;
import com.sun.source.tree.Tree;

import java.util.*;
class treecode10{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}

    }
    public static  void main(String[]args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.substring(1, s.length() - 1).split(",");
        TreeNode treeNode = BuilderTree(split);
        ArrayList<Integer> list = new ArrayList<>();
        rightview(treeNode,list);
        System.out.println(list);

    }
    public static void rightview(TreeNode root, List<Integer>list){
        if(root==null)return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode poll = q.poll();
                if(poll.left!=null){
                    q.offer(poll.left);
                }
                if(poll.right!=null){
                    q.offer(poll.right);
                }
                if(size==0){
                    list.add(poll.val);
                }

            }
        }

    }
 public static TreeNode BuilderTree(String []nums){
        if(nums.length==0||nums[0].equals("null")|| nums[0].isEmpty())return null;
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(nums[0]));
        int index=1;
        q.offer(root);
        while(!q.isEmpty()&&index<nums.length){
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