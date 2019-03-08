class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int start = 0;
        int end = 0;
        
        int len = s.length();
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        
        while(start < len && end < len)
        {
            if(!set.contains(s.charAt(end)))
            {
                set.add(s.charAt(end++));
                ans = Math.max(ans , end-start);
            }
            
            else
            {
                set.remove(s.charAt(start++));
            }
                
            
        }
        
        return ans;
        
        
    }
}
