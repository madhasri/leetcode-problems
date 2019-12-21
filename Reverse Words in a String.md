### Problem Desciption

Given an input string, reverse the string word by word.

### Easy to Understand Solution

### Code

```
class Solution {
    public String reverseWords(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right && s.charAt(left) == ' ')
            left++;
        
        while(left < right && s.charAt(right) == ' ')
            right--;
        
        // use a deque to add tokens one by one
        
        Deque<String> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            if((sb.length() > 0) && (s.charAt(left) == ' ')) {
                dq.addFirst(sb.toString());
                sb.setLength(0);
            }
            else if(s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        dq.addFirst(sb.toString());
        
        return String.join(" ", dq);
    }
}
```


### Run-time Complexity

O(N)

### Space-time Complexity
O(N)

