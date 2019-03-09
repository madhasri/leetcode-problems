class Solution 
{
    
    int sumPathNums(TreeNode root  , int tempSum )
    {
        tempSum = tempSum*10 + root.val;
        
        int leftSum = 0;
        int rightSum = 0;
        
        if(root.left == null && root.right == null)
        {
            return tempSum;
        }
        
        if(root.left != null)
            leftSum = sumPathNums(root.left,tempSum);
        
        if(root.right != null)
            rightSum = sumPathNums(root.right,tempSum);
        
        return(leftSum + rightSum);
    }
    
    
    public int sumNumbers(TreeNode root) {
        
        if(root != null)
        return sumPathNums(root , 0);
        
        return 0;
        
    }
}
