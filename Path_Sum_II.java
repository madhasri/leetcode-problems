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
    
    int finalSum;
    List<List<Integer>> resList = new ArrayList<>();
    
    void dfsPaths(TreeNode root , String res , int sum)
    {
        if(root.left == null && root.right == null)
        {
            sum += root.val;
            res += root.val + ".";
            
            if(sum == finalSum)
            {
                
                ArrayList<Integer> newList = new ArrayList<>();
                String[] split = res.split("\\.");
                for(int i=0 ; i < split.length;i++)
                {
                    newList.add(Integer.parseInt(split[i]));
                }
                
                resList.add(newList);
            }
            
                
        }
        
        sum += root.val;
        res += root.val + ".";
        
        if(root.left != null)
        {
            
            dfsPaths(root.left,res,sum);
        }
        
        if(root.right != null)
        {
            dfsPaths(root.right ,res,sum);
        }
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if(root == null) return resList;
        finalSum = sum;
        String res = "";
        dfsPaths(root, res , 0);
        return resList;
    }
}
