class Solution {
    
    String getKeyString(String S)
    {
        StringBuilder key = new StringBuilder();
        
        key.append(S.charAt(0));
        char target = S.charAt(0);
       for(int i = 1 ; i < S.length() ; i++)
       {
           if(! (S.charAt(i) == target))
           {
            
               key.append(S.charAt(i));
               target = S.charAt(i);
           }
       }
        
        return key.toString();
        
    }
    
    int[] getGrpCounts(String S , int n)
    {
        int[] grpCount = new int[n];
        grpCount[0] = 1;
        int grp = 0;
        char target = S.charAt(0);
       for(int i = 1 ; i < S.length() ; i++)
       {
           if(S.charAt(i) == target)
           {
               grpCount[grp]++;
               
           }
           else
           {
               
               grp = grp + 1;
               grpCount[grp] = 1;
               target = S.charAt(i);
           }
       }
        
        return grpCount;
    }
    
    public int expressiveWords(String S, String[] words) {
        
        int res = 0;
        String Skey = getKeyString(S);
        int[] grpCounts = getGrpCounts(S,Skey.length());
                
       for(int i=0 ; i< words.length ; i++)
       {
           boolean isValid = true;
           String wordKey = getKeyString(words[i]);
           
           if(wordKey.equals(Skey))
           {
               int[] wordGrpCnts = getGrpCounts(words[i] , wordKey.length());
               
               for(int j=0 ; j < wordGrpCnts.length ; j++)
               {
                   if(grpCounts[j] < 3)
                   {
                       if(grpCounts[j] != wordGrpCnts[j])
                       {
                           isValid = false;
                           break;
                       }
                       
                   } 
                   
                   if(wordGrpCnts[j] > grpCounts[j])
                       {
                           isValid = false;
                           break;
                       }
                   
                   
               }
               
               if(isValid)
               {
                   
                   res++;
               }
                   
           }
           
       }
        
              
        return res;
      
        
    }
}
