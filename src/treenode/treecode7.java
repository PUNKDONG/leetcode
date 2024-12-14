package treenode;

import java.util.*;

public class treecode7
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
       Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.substring(1, s.length() - 1).split(",");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        TreeNode helper = helper(array, 0, array.length - 1);

        ArrayList<String> strings = new ArrayList<>();
        chenxu(helper,strings);

        System.out.println(strings);

    };
     public static void chenxu(TreeNode root,List<String>  result){
         if(root==null)return;
         Queue<TreeNode> q=new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
             int size = q.size();
             while (size-->0){
                 TreeNode poll = q.poll();
                 if(poll!=null) {
                     result.add(String.valueOf(poll.val));
                     q.offer(poll.left);
                     q.offer(poll.right);
                 }
                 else{
                     result.add("null");
                 }
             }
         }
     }
    public static TreeNode helper(int nums[],int left,int right){
        if( left>right)return null;
        int mid=(left+right)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left=helper(nums,left,mid-1);
        treeNode.right=helper(nums, mid+1,right );
        return treeNode;

    }


}