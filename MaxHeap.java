package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class implements a Max Heap data structure and contains several useful methods associated with the data structure
 */
public class MaxHeap<T> {
	private List<T> list = new ArrayList<T>();  
	Comparator<T> comparator=null;
	 
	/** Default constructor for the class
	 * 
	 */
	public MaxHeap() {
		// TODO Auto-generated constructor stub
		buildMaxHeap();
	}
	/**
	 * Constructor that takes a comparator as an argument. This comparator will be used to compare two objects of Type T.
	 * @param comparator
	 */
	public MaxHeap(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		this.comparator=comparator;
	}
	
	/**
	 * Constructor that takes a List<T> as an argument, which is then restructured to fulfill the MaxHeap condition
	 * @param arrayList
	 */
	public MaxHeap(List<T> arrayList) {
		this.list.addAll(arrayList);
		buildMaxHeap(); // transforms the List into a MaxHeap data structure
	}
	
	/**
	 * Constructor that takes a List<T> and a comparator method as arguments
	 */
	public MaxHeap(List<T> arrayList,Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		//this.arrayList=arrayList;
		this.list.addAll(arrayList);
		this.comparator=comparator;
		buildMaxHeap();
	}
	
	/**
	 * Compares two elements of type T of the heap. 
	 * First, try using the Comparator, if available.
	 * Otherwise, the method will assume that the class T implements the Comparable interface.
	 * A casting error will be thrown if none of the above conditions has been met. 
	 */
	protected int compare(T element1,T element2) {
		if(comparator!=null)
			return comparator.compare(element1, element2);
		else
		{
			Comparable<T> c1=(Comparable<T>)element1;
			return c1.compareTo(element2);
		}
	}
	
	/**
	 *  Gets the left child of the node specified by index
	 * @param index
	 * @return
	 */
	private int leftChild(int index) {
		if((2*index+1)>list.size()-1) //checks if the child index is out of bound
			return -1;
		return 2*index+1;
	}
	
	/**
	 *  Gets the right child of the node specified by index
	 * @param index
	 * @return
	 */
	private int rightChild(int index) {
		if((2*index+2)>list.size()-1) //checks if the child index is out of bound
			return -1;
		return 2*index+2;
	}
	
	/**
	 *  Gets the parent of the node specified by index
	 * @param index
	 * @return
	 */
	private int parent(int index) {
		if(index==0) return -1; // the root has no parents
		return (index-1)/2;
	}
	
	/** Method that checks for the proper structure of the maxheap, and recursively restructures the tree
	 * 
	*/
	private void heapify(int index) {
		int largest;
		int left=leftChild(index);
		int right=rightChild(index);
		if((left!=-1)||(right!=-1)) { // makes sure that the indexes of the children are not out of bound
			if(compare(list.get(left), list.get(index))>0) // determines the largest between the parent and the left child
				largest=left;
			else
				largest=index;
			if((right!=-1)&&(compare(list.get(right), list.get(largest))>0)) // determines the largest between the parent and the  two children
				largest=right;
			if(index!=largest) { // if one of the children is larger than the parent, the parent and that child swap values
				T temp=list.get(largest);
				list.set(largest, list.get(index));
				list.set(index, temp);
				heapify(largest);
			}
		}
	}
	
	/**
	 * Method that transforms a list of objects of type T into a MaxHeap data structure by heapifing 
	 * at least half of its elements
	 */
	private void buildMaxHeap() {
		for(int i=(list.size()/2)+1;i>=0;i--) {
			heapify(i);
		}
	}
	
	/**
	 * The last element has just been added to the end of the list, and now needs to be heapified.
	 * @param arrayList 
	 */
	private void increaseKey() { 
		T temp;
		int index=list.size()-1;
		int parentIndex=parent(index);
		while((parentIndex>=0)&&(compare(list.get(index),list.get(parentIndex))>0)) {
			temp=list.get(parentIndex);
			list.set(parentIndex,list.get(index));
			list.set(index, temp);
			index=parentIndex;
			parentIndex=parent(index);
		}
	}
	
	
	/**
	 * Method that returns the maximum element of the MaxHeap
	 * @return
	 */
	public T top() {
		if(list.isEmpty()) 
			return null;
		else
			return list.get(0);
	}
	
	/**
	 * Method that returns the maximum element of the MaxHeap, and also removes it from the maxheap
	 */
	public T pop() {
		if(list.isEmpty()) 
			return null;
		T temp=list.get(0);
		list.set(0, list.get(list.size()-1)); // the last element of the heap is put temporarily at the root of the heap
		list.remove(list.size()-1); // the last element is removed
		heapify(0); // the List is heapified from the root
		return temp;
	}
	
	/**
	 * Method that inserts one element of type T into a MaxHeap
	 */
	public void insert(T element) {
		list.add(list.size(), element); 
		increaseKey(); 
	}
	
	/**
	 * Method that inserts a List<T> into a MaxHeap
	 */
	public void insert(List<T> addedList) {
		for(T t:addedList){
			insert(t); 		}
	}
		
	/* 
	 * Iterator function for the heap
	 * 
	public Iterator<T> iterator() {
		return new MaxHeapIterator<T>();
	}
	
	private class MaxHeapIterator<T> implements Iterator<T> {

		int currentPosition = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (currentPosition<arrayList.size());
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return (T) arrayList.get(currentPosition++);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			arrayList.remove(currentPosition);
		}
		
	}
	*/
	
	/**
	 * Method that returns an array sorted in descending order based on the MaxHeap structure.
	 */
	public T[] getSortedArray() {
		List<T> tempList= new ArrayList<T>();
		tempList.addAll(list);
		T[] array= (T[]) new Object[list.size()];
		for(int i=0;i<array.length;i++) {
			array[i]=list.get(0);
			list.set(0, list.get(list.size()-1));
			list.remove(list.size()-1);
			heapify(0);
		}
		
		list.addAll(tempList);
		return array;
	}
	
	
}
