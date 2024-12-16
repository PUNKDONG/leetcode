 package treenode;
import javax.swing.text.html.StyleSheet;
import java.util.*;
class treecode14{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }
    public static void main (String []args){
        Scanner sc=new Scanner(System.in);

            String s = sc.nextLine();

            String[] split = s.substring(1, s.length() - 1).split(",");
            TreeNode root=buildTree(split);
            int targetsum = sc.nextInt();
            System.out.println(allnum(root,targetsum));


    }
    public static TreeNode buildTree(String[]nums){
        if(nums.length==0||nums[0].equals("null")||nums[0].isEmpty())return null;
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(nums[0]));
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
    public static int allnum(TreeNode root,long targetsum){
        if(root==null)return 0;

        int rootnum=rootnum(root,targetsum);
        int left=allnum(root.left,targetsum);
        int right=allnum(root.right,targetsum);
        return rootnum+left+right;
    }
    public static int rootnum(TreeNode root,long targetsum){
        if(root==null)return 0;
        int num=0;
        if(root.val==targetsum){
            num++;
        }
        num=num+rootnum(root.left,targetsum-root.val);
        num=num+rootnum(root.right,targetsum-root.val);
        return num;
    }


}