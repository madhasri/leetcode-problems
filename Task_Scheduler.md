### Problem Description

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

### Easy to Understand Solution

Suppose the task list was like "A" , "A" , "A" , "A" , "B" , "B" , "C" , "D" with n = 4
Basically we need to identify the minimum idle time slots. Going with the greedy approach, to ensure that there are n spaces between any repeated tasks, identify if there are (n+1) unique tasks that can be done. If there are good, otherwise fill the rest with idle slots.

A B C D idle A B idle idle idle A idle idle idle idle A

ans = 16


### code 
```
class Solution {
    
    class Task
    {
        char ch;
        int count;
        
        Task(char ch , int count)
        {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        
        int noOfTasks = tasks.length;
        
        int[] taskCount = new int[26];
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        
        for(int i=0 ; i< tasks.length ; i++)
        {
            taskCount[tasks[i] - 'A']++;
        }
        
        for(int i=0 ; i<26 ; i++)
        {
            if(taskCount[i] > 0)
            {
                char c = (char)('A' + i);
                Task t = new Task(c,taskCount[i]);
                pq.add(t);
            }
        }
        
        int idleCount = 0;
        ArrayList<Task> tempList = new ArrayList<>();
        while(!pq.isEmpty())
        {
            tempList.clear();
            
            for(int i=0 ; i< n+1; i++)
            {
                if(!pq.isEmpty())
                {
                    Task t = pq.poll();
                    t.count -= 1;
                    if(t.count > 0)
                    tempList.add(t);
                }
                else
                {
                    if(tempList.size() > 0)
                    idleCount++;
                }
            }
            
            for(Task t : tempList)
            {
                
                    pq.add(t);
            }
            
        }
        
        return noOfTasks + idleCount;
        
        
    }
}
```

### Run Time Complexity
O(n) where n is the total number of time intervals

### Space Time Complexity
for priority queue and temp list worst case : O(26)
