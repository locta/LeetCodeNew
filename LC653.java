// Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

// Example 1:
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 9

// Output: True
// Example 2:
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 28

// Output: False

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, k, root);
    }
    
    private boolean findTarget(TreeNode current, int k, TreeNode root) {
        if (current == null) {
            return false;
        }
        return current.val * 2 != k && find(root, k - current.val)  
            || findTarget(current.left, k, root) 
            || findTarget(current.right, k, root);
    }
    
    private boolean find(TreeNode root, int k) {
        if (root == null) {
            return false;
        } else if (root.val == k) {
            return true;
        }
        if (root.val > k) {
            return find(root.left, k);
        }
        return find(root.right, k);
    }
}