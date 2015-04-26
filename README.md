# MaxHeap
Repository for my Max Heap Class
## Introduction. 
A priority queue is an  data type where each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue. 

One of the most trivial ways to implement a priority queue is through a sorted array. However, this simple solution does come with its disadvanatges. Specifically, the complexity for sorting an array is O(NlgN), and for updating a sorted array with a newly inserted element O(N). This complexity can be vastly improved by the use a heap structure, which has complexity of O(N) for building the structure from scratch and O(lgN) for updating.

## MaxHeap structure
A binary heap data structure, in general, is an array object that can be viewed as nearly complete binary tree. Each node of the tree corresponds to an element of the the array that stores the value in the node. The tree is completely filled on all levels except possibly the lowest, which is filled from the left up to a point. 

heap can be either a Min Heap or a Max Heap, both havve very similar structures. I wil discuss a Max Heap here.

It is basically an array, where elements are positions in such a way in order to aid the process of retrieving the max, and update...

## Implementation
Explain methods
* heapify, why it is needed
* insert, explain comparator and comparable
* heap sort as an alternative to merge sort and quick sort
 



A heap is one of the most efficient implementations of a priority queu. It's time complexity is O(lgN), much better than that of a sorted array which has a complexity of O(N). However, the implementation of a heap is not as commonly seen as a linked list.
In the class I wrote, I implement this 
