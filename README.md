# MaxHeap
Notes for my MaxHeap Class
## Introduction. 
A priority queue is an  data type where each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue. 

One of the most trivial ways to implement a priority queue is through a sorted array. However, this simple solution does come with its disadvanatges. Specifically, the complexity for sorting an array is O(NlgN), and for updating a sorted array with a newly inserted element O(N). This complexity can be vastly improved by the use a heap structure, which has complexity of O(N) for building the structure from scratch and O(lgN) for updating.

## MaxHeap structure
A binary heap data structure, in general, is an array object that can be viewed as nearly complete binary tree. Each node of the tree corresponds to an element of the the array that stores the value in the node. The tree is completely filled on all levels except possibly the lowest, which is filled from the left up to a point. 

There are two kinds of binary heap:max-heaps and min-heaps. In both kinds, the values in the nodes satisfy a **heap property**, the specifics of which depend on the kind of heap. In a max-heap, the max-heap property is that for every node *i* other than the root, PARENT>=CHILD that is, the value of a node is at most the value of its parent. Thus, the largest element in a max-heap is stored at the root, and the subtree rooted at a node contains vales no larger than that contained at the node itself. The image below represents a max-heap

![Alt text](https://github.com/phsimo/MaxHeap/blob/master/MaxHeap.gif "Max Heap Structure")

A **min-heap** is organized in the opposite way; the **min-heap property** is that for every node *i* other than the root,
PARENT<=CHILD, thus the smallest element in a min-heap is at the root.

## Implementation
At the heart of the heap class reside four methods:

1. heapify: The core method of the class that checks and maintains the proper structure of the max-heap starting from the elemement specified by "index"

 ```java
 private void heapify(int index){
   // maintain the proper structure of a max heap
 }
 ```
2.increaseKey: when a new element is inserted to the end of the heap, that element needs to be positioned in the right place in the max-heap, specifically by floating up the binary tree.
 ```java
  private void increaseKey() {
  // maintains the structure of a heap after a new element has been inserted into it
  }
 ```

3. insert: a single element or a list of elements of type T. This method will call the increaseKey method to assure that the structure of the max-heap is maintained properly.
 ```java
  public void insert(T element) {
  // insert an element of typ T in the heap
 ```
 
 ```java
  public void insert(List<T> element) {
   // insert a list of type T in the heap
 ```

4. heapSort: this method makes use of the heap to sort an array with time complexity O(NlgN). It sorts the array by repeatedly removing the root (the maximum element) of the heap and calling heapify at the root.

 ```java
  public T[] getSortedArray() {
  // returns a sorted array in descending order
  }
 ```
## Complexity
Getting the maximum element of the heap without removing has complexity O(1).

Getting and removing the maximum element of the heap has complexity O(lgN).

Building a max-heap - O(N)

Heapify - O(lgN)

HeapSort - O(NlgN)
