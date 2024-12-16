package treenode;

import com.sun.source.tree.Tree;

import java.util.*;
class treecode9{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}

    }
    public static void main (String []args){
    Scanner s=new Scanner(System.in);
        String s1 = s.nextLine();
        String[] split = s1.substring(1, s1.length() - 1).split(",");
        TreeNode treeNode = BuildTree(split);
        int k=s.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        bianli(treeNode,integers);
        System.out.println(integers.get(k-1));


    }
    public static void bianli(TreeNode root,List<Integer> list){
        if(root==null)return;
        bianli(root.left,list);
        list.add(root.val);
        bianli(root.right,list);
    }
    public static TreeNode BuildTree(String[] split){
        if(split.length==0||split[0].equals("null"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int index=1;
        while(!q.isEmpty()&&index<split.length){
            TreeNode node=q.poll();
            if(!split[index].equals("null")){
                node.left=new TreeNode(Integer.parseInt(split[index]));
                q.offer(node.left);
            }
            index++;
            if(index<split.length&&!split[index].equals("null")){
                node.right=new TreeNode(Integer.parseInt(split[index]));
                q.offer(node.right);
            }
            index++;
        }
        return root;
    }
        }