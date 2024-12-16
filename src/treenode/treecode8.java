package treenode;



import com.sun.source.tree.Tree;

import java.util.*;

public class treecode8{

static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val=val;}
}
public static void main(String[]args){
    Scanner in=new Scanner(System.in);
    String s = in.nextLine();
    int k= in.nextInt();
    String value[]=s.substring(1,s.length()-1).split(",");
    TreeNode buildtree = Buildtree(value);

    System.out.println(kthsmall(buildtree,k));
}
    public static int  kthsmall(TreeNode root,int k){
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,list);
        Collections.sort(list);
        System.out.println(list);
        return list.get(k-1);
    }

    public static void helper(TreeNode root, List<Integer> list){
    if(root==null){return ;}

     list.add(Integer.valueOf(root.val));

        helper(root.left,list);
        helper(root.right,list);

    }


public static TreeNode Buildtree(String[]nums){
    if(nums.length==0||nums[0].equals("null"))return null;
    TreeNode root=new TreeNode(Integer.parseInt(nums[0]));
    Queue<TreeNode> q=new LinkedList<>();
    q.offer(root);
    int index=1;
    while(!q.isEmpty()&& index<nums.length){
            TreeNode poll=q.poll();
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