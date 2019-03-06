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
    List<String> resList = new ArrayList<>();
    
    void dfsPaths(TreeNode root ,String sb )
    {
        
        
        
        
        if(root.left == null && root.right == null)
        {
            sb  = sb + root.val;
            resList.add(sb.toString());
        }
            
            
        if(root.left != null)
            dfsPaths(root.left,sb + root.val + "->");
        
        if(root.right != null)
            dfsPaths(root.right,sb + root.val + "->");
        
        
        
            
    }
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        if(root != null)
        {
            dfsPaths(root,"");
            
        }
                
        return resList;
        
    }
}
