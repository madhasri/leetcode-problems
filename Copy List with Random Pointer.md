### Problem Description

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

### Easy to understand Solution

Imagine the linked list as a graph, where each node has two edges coming out from it, next and random. We need to do a depth-first traversal of the graph and keep track of visited nodes. As we visit the nodes, we create copies. To keep track of visited nodes, we maintain a map of old nodes to new nodes. 

### Code

```
class Solution {
    
    Map<Node,Node> nodeMap = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (nodeMap.containsKey(head)) {
            return nodeMap.get(head);
        }
        Node n = new Node(head.val);
        nodeMap.put(head,n);
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);
        return n;
    }
}

```

### Time Complexity

O(N)

### Space Complexity

O(N)

