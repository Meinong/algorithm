package com.huaizhu;

import java.util.ArrayList;
import java.util.List;

public class 判断一棵树的某条路径和等于某个值并收集路径 {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


    public static List<List<Integer>> pathSum(TreeNode root,int sum){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        process(root,new ArrayList<>(),0,sum,ans);
        return ans;
    }


    public static void process(TreeNode x,List<Integer> path,int preSum,int sum,List<List<Integer>> ans){
        if(x.left == null && x.right == null){
            if(preSum + x.val == sum){
                path.add(x.val);
                ans.add(copy(path));
                path.remove(path.size() -1);
            }
            return;
        }
        preSum += x.val;
        path.add(x.val);
        if(x.left != null){
            process(x.left,path,preSum,sum,ans);
        }
        if(x.right != null){
            process(x.right,path,preSum,sum,ans);
        }
        path.remove(path.size() -1);
        return;
    }


    public static List<Integer> copy(List<Integer> path){
        List<Integer> ans = new ArrayList<>();
        for (Integer val : path){
            ans.add(val);
        }
        return ans;
    }



}
