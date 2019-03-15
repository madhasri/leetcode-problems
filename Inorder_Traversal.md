### Problem Description

Given a binary tree, return the inorder traversal of its nodes' values.

### Easy to Understand Solution

Inorder Traversal has visiting order like : left child , parent and then right child.
Recusrsive solution is easy as it uses the function call stack.
Iterative solution requires an explicit stack data structure. Idea is to keep pushing to the stack and going left, and when no more left child present then start popping and printing. While doing this popping and printing, if there is a right child of the current node then push that to the stack.

### code

void inOrder(TreeNode root)
{
if(root == null) return;

inOrder(root.left);
System.out.println(root.val);
inOrder(root.right);

}



### code 
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        
        List<Integer> res = new ArrayList<>();
        
        Stack<TreeNode> s = new Stack<>();
        
        while(true)
        {
            if(root != null)
            {
                s.push(root);
                root = root.left;
            }
            
            else
            {
               if(s.isEmpty()) break;
               root = s.pop();
               res.add(root.val);
               root = root.right;
            }
        }
        
        return res;
        
    }
}
```

### Run Time Complexity
O(n) where n is the total number of nodes in the tree

### Space Time Complexity
for the stack, O(h) where h is the height of the tree. In the worst case, h will equal to n

