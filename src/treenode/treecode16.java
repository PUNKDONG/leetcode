 package treenode;

 import java.util.LinkedList;
 import java.util.Queue;
 import java.util.Scanner;

 class treecode16 {
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
             if(s.isEmpty())break;;
             String[] split = s.substring(1, s.length() - 1).split(",");
             TreeNode root = buildtree(split);
             int[]max={Integer.MIN_VALUE};
             maxPathSum(root,max);
             System.out.println(max[0]);
         }



     }
     public static  int maxPathSum(TreeNode root,int[]max) {
         if(root==null )return 0;
         int left=maxPathSum(root.left,max);
         int right=maxPathSum(root.right,max);
         int all=left+right+root.val;
         int max1=Math.max(left+root.val,right+root.val);
         int max2=Math.max(root.val,max1);
         int max3=Math.max(all,max2);

         max[0]=Math.max(max[0],max3);
         if(max2<0)return 0;
        return max2;
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
