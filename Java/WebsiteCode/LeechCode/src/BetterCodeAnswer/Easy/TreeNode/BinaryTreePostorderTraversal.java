package BetterCodeAnswer.Easy.TreeNode;

import java.util.List;

import Easy.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/binary-tree-postorder-traversal/">145. Binary Tree Postorder Traversal</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a&nbsp;binary tree, return <em>the postorder traversal of its nodes' values</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[3,2,1]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;"></p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[4,6,7,5,2,9,8,3,1]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;"></p>
 * </div>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = []</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[]</span></p>
 * </div>
 * 
 * <p><strong class="example">Example 4:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">root = [1]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[1]</span></p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of the nodes in the tree is in the range <code>[0, 100]</code>.</li>
 * 	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</div>
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Object[][] tests = {
            {1,2,3,4},
            {1,2,3,null,4},
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new BinaryTreePostorderTraversal_Solution().postorderTraversal(root));
        }
    }
}

// @see Easy.TreeNode.BinaryTreePostorderTraversal.java
class BinaryTreePostorderTraversal_Solution {

    static List<Integer> result;

    public List<Integer> postorderTraversal(TreeNode root) {
        return result;
    }
}