 package treenode;
import com.sun.source.tree.Tree;

import java.util.*;
class treecode12{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }
    static  HashMap<Integer,Integer> mymap=new HashMap<>();
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] s1nums = s1.substring(1, s1.length() - 1).split(",");
        String s2 = sc.nextLine();
        String[] s2nums = s2.substring(1, s2.length() - 1).split(",");
        int[] preorder = Arrays.stream(s1nums).mapToInt(Integer::parseInt).toArray();
        int[] inorder = Arrays.stream(s2nums).mapToInt(Integer::parseInt).toArray();

        TreeNode root = buildtree(preorder, inorder);
        chen(root);

    }

    public static void chen(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode poll = q.poll();
            if(poll==null)System.out.print( "null ");
            else{
                System.out.print(poll.val+" ");
                q.offer(poll.left);
                q.offer(poll.right);
            }

        }
    }
    public static TreeNode buildtree(int[]preorder,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            mymap.put(inorder[i],i);
        }
        int[] index = {0};
        TreeNode helper = helper(preorder, inorder, 0, inorder.length, index);
        return helper;

    }
    public static TreeNode helper(int[]preorder,int[] inorder,int left,int right,int[] index){
        if(left>right||index[0]>=preorder.length)return null;
        int rootval = preorder[index[0]];
        index[0]++;
        int rootindex=mymap.get(rootval);
        TreeNode root=new TreeNode(rootval);
        root.left=helper(preorder,inorder,left,rootindex-1,index);
        root.right=helper(preorder,inorder,rootindex+1,right,index);
        return root;
    }
}