package sorting;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MaxHeapTest{
	List<Integer> arrayList = new ArrayList<Integer>();
	MaxHeap<Integer> heap;
	
	public void fillArrayList() {
		arrayList.add(new Integer(0));
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		arrayList.add(new Integer(4));
	}
	
	@Test
	public void testEmptyTop() {
		heap=new MaxHeap<Integer>();
		Assert.assertEquals(null, heap.pop());
	}
	
	@Test
	public void testEmptyPop() {
		heap=new MaxHeap<Integer>();
		Assert.assertEquals(null, heap.pop());
	}
	
	@Test
	public void testTop() {
		fillArrayList();
		heap=new MaxHeap<Integer>(arrayList);
		Assert.assertEquals(new Integer(4).intValue(), heap.top().intValue());
	}
	
	@Test
	public void testPop(){
		fillArrayList();
		heap=new MaxHeap<Integer>(arrayList);
		int max1=heap.pop().intValue();
		int max2=heap.pop().intValue();
		Assert.assertEquals(true, max1>max2);
	}
	
	@Test
	public void testInsert() {
		heap= new MaxHeap<Integer>();
		heap.insert(new Integer(6));
		Assert.assertEquals(new Integer(6).intValue(), heap.top().intValue());
	}
	
	@Test
	public void testArrayInsert() {
		fillArrayList();
		heap=new MaxHeap<Integer>();
		heap.insert(arrayList);
		for (int i=4;i>=0;i--) {
			Assert.assertEquals(i, heap.pop().intValue());
		}		
	}
	
	@Test
	public void testGetSortedArray() {
		fillArrayList();
		heap=new MaxHeap<Integer>(arrayList);
		Integer[] array={4,3,2,1,0};
		Assert.assertArrayEquals(array, heap.getSortedArray());
	}
}
