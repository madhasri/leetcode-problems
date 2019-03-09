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
    
    ArrayList<String> rootToLeafPaths = new ArrayList<>();
    
    void getRootLeafPaths(TreeNode root , String temp)
    {
        char c = (char)(root.val + 'a');
        temp += c;
        
        if(root.left == null && root.right == null)
        {
            rootToLeafPaths.add(temp);
        }
        
        if(root.left != null)
            getRootLeafPaths(root.left , temp);
        
        if(root.right != null)
            getRootLeafPaths(root.right , temp);
        
        
    }
    
    
    public String smallestFromLeaf(TreeNode root) {
        
        getRootLeafPaths(root,  "");
        
        
        String[] reverseStrs = new String[rootToLeafPaths.size()];
        
        int i = 0;
        for(String s : rootToLeafPaths)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb = sb.reverse();
            reverseStrs[i++] = sb.toString();
        }
        
        for(i = 0; i< reverseStrs.length; i++)
        {
            
            System.out.println(reverseStrs[i]);
        }
        
        Arrays.sort(reverseStrs);
            
        
        return reverseStrs[0];
        
        
        
        
        
    }
}
