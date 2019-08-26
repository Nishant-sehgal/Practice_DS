package com.qs;

import java.util.HashSet;
import java.util.Set;

public class MaxPathSum {

	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(-10);
		TreeNode node5 = new TreeNode(9);
		TreeNode node4 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node2 = new TreeNode(7);
		node6.left = node5;
		node6.right = node4;
		node4.left = node3;
		node4.right = node2;
		maxPathSum(node6);
	}

	public static int maxPathSum(TreeNode root) {
		maxPathSumHelper(root);
		int val = findMax(root);
		return val;
	}

	public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int curSum = 0;
        for(int num:nums){
            set.add(num);
            curSum+=num;
        }
        
      int sum=0;
      for (Integer integer : set) {
		sum+=integer;		
	}
      sum = sum*2;
      return (sum-curSum)/2;
    }
	public static int maxPathSumHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSumHelper(root.left);
		int rightSum = maxPathSumHelper(root.right);
		int sum = root.val + leftSum + rightSum;
		int sum1 = root.val + leftSum;
		int sum2 = root.val + rightSum;
		root.val = Math.max(Math.max(Math.max(sum,sum1),sum2),root.val);	
		return root.val;
	}

	public static int findMax(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.val, Math.max(findMax(root.left), findMax(root.right)));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
