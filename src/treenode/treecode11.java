package treenode;

import java.util.*;
class treecode11{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}

    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.substring(1, s.length() - 1).split(",");
        TreeNode root = buildtree(split);
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<Integer> ilist = new ArrayList<>();
        buildlist(root,list,ilist);

        TreeNode p=root;
        for(int i=0;i<list.size();i++){
            p.left=null;
            p.right=list.get(i);
            p=p.right;
        }

        TreeNode newp=root;
        while(newp!=null ){
            System.out.println(newp.val);
            newp=newp.right;
        }

    }
    public static void buildlist(TreeNode root,List<TreeNode>list,List<Integer>ilist){
        if(root==null)return;
        list.add(root);

        ilist.add(root.val);
        buildlist(root.left,list,ilist);
        buildlist(root.right,list,ilist);
    }
    public static TreeNode buildtree(String[]nums){
        if(nums.length==0||nums[0].equals("null")||nums[0].isEmpty())return null;
        TreeNode root=new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int index=1;
        while(index<nums.length&&!q.isEmpty() ){
            TreeNode poll = q.poll();
            if(!nums[index].equals("null")){
                poll.left=new TreeNode(Integer.parseInt(nums[index]));
                q.offer(poll.left);
            }
            index++;
            if(index< nums.length&&!nums[index].equals("null")){
                poll.right=new TreeNode(Integer.parseInt(nums[index]));
                q.offer(poll.right);
            }
            index++;
        }
        return root;
    }

}