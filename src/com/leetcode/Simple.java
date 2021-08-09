package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Simple {

    @Test
    public void test(){
        /**
         * 输入：root = [1,null,2,3]
         * 输出：[1,2,3]
         */
        TreeNode root = new TreeNode(1);
        root.left=null;
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        node1.right = null;
        node1.left = new TreeNode(3);
        System.out.println(preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
        /**
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了21.48%的用户
         */
    }

    public void preOrder(TreeNode root, List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
        /**
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了23.53%的用户
         */
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if (root==null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
        /**
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.4 MB, 在所有 Java 提交中击败了88.96%的用户
         */
    }

    public void postOrder(TreeNode root, List<Integer> list){
        if (root==null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
