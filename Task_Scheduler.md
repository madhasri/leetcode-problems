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
