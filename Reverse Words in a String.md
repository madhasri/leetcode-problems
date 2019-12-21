### Problem Desciption

Given an input string, reverse the string word by word.

### Easy to Understand Solution

There are multiple ways to do this, using inbuilt methods
the basic idea is to tokenize and then create a new string that contains the tokens in reverse order

There can be multiple spaces between the words, before and after the string as well.
First identify the left and right index that marks the beginning and end of the input string (this gets rid of the leading and trailing spaces)

Use StringBuilder to store the token
Add tokens to a deque. To get a reverse order, use addFirst
Once a token is added to the deque, set length of the stringbuilder to zero
In case there are multiple spaces, they can be handled by a simple check during adding of characters to the StringBuilder


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

O(N) - where N is the number of input characters

### Space-time Complexity
O(N) - to store the final result, tokens separated by a space

