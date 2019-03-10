class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        
        HashMap<Character,Character> charMap;
        List<String> resList = new ArrayList<>();
        
        for(int i=0; i< words.length ; i++)
        {
            boolean isValid = true;
            charMap = new HashMap<>();
            if(words[i].length() == pattern.length())
            {
                for(int j = 0 ; j< words[i].length() ; j++)
                {
                    char p = pattern.charAt(j);
                    char w = words[i].charAt(j);
                
                    if(!charMap.containsKey(w))
                        charMap.put(w,p);
                    else
                    {
                        if(charMap.get(w) != p) {isValid = false; break;}
                        
                    }
                
                }
                
                //extra loop to check there are no duplicates in the hashMap values
                
                boolean[] seen = new boolean[26];
                
                for(char w : charMap.values())
                {
                    if(seen[w - 'a'])  {isValid = false; break;}
                    seen[w - 'a'] = true;
                }
              if(isValid)
                  resList.add(words[i]);
                
            }
            
            
        }
        
        return resList;
        
        
        
    }
}
