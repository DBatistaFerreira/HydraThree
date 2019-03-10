import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

import java.util.Arrays;

@invariant({"$this.sizeOfHeap >= 0",
			"$this.boundCapacity > 0",
			"$this.heapArray != null"})
public class BoundedPriorityQueue<T extends Comparable<T>>{
	
	public int sizeOfHeap;
	public int boundCapacity;
	
	public T[] heapArray;
	
	@requires({"true"})
	@ensures({"true"})
	public BoundedPriorityQueue() {
		this.boundCapacity = 10;
		this.heapArray = (T[])new Comparable[this.boundCapacity];
		this.sizeOfHeap = 0;
	}
	
	@requires({"boundCapacity > 0"})
	@ensures({"true"})
	public BoundedPriorityQueue(int boundCapacity) {
		this.boundCapacity = boundCapacity;
		this.heapArray = (T[])new Comparable[this.boundCapacity];
		this.sizeOfHeap = 0;
	}
	
	@requires({"true"})
	@ensures({"true"})
	public void insert(T newItem) {
		//gotta check bound capacity
		
		this.sizeOfHeap++;
		heapArray[sizeOfHeap] = newItem;
		
		heapifyUp();
	}
	
	@requires({"true"})
	@ensures({"true"})
	public T remove() {
		T highestPriority = min();
		
		heapArray[1] = heapArray[sizeOfHeap];
		heapArray[sizeOfHeap] = null;
		sizeOfHeap--;
		
		heapifyDown();
		
		return highestPriority; 
	}
	
	@requires({"true"})
	@ensures({"true"})
	public T min() {
		return heapArray[1];
	}
	
	public boolean isEmpty() {
		return (sizeOfHeap == 0);
	}
	
	public String toString() {
		return Arrays.toString(heapArray);
	}
	
	private void heapifyDown() {
		int index = 1;
		
		while(hasLeftChild(index)) {
			int smallerChild = getLeftChildIndex(index);
			
			if(hasRightChild(index) && heapArray[getLeftChildIndex(index)].compareTo(heapArray[getRightChildIndex(index)]) > 0) {
				smallerChild = getRightChildIndex(index);
			}
			
			if(heapArray[index].compareTo(heapArray[smallerChild]) > 0){
				 swap(index, smallerChild);
			} 
			else {
				break;
			}
			
			index = smallerChild;
		}
	}
	
	private void heapifyUp() {
		int index = this.sizeOfHeap;
		while(hasParent(index) && getParent(index).compareTo(heapArray[index]) > 0) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	private void swap(int indexOne, int indexTwo) {
		T temp = heapArray[indexOne];
		heapArray[indexOne] = heapArray[indexTwo];
		heapArray[indexTwo] = temp;
	}
	
	private boolean hasParent(int index) {
		return (index> 1);
	}
	
	private int getLeftChildIndex(int index) {
		return (index * 2);
	}
	
	private int getRightChildIndex(int index) {
		return ((index * 2) + 1);
	}
	
	private int getParentIndex(int index) {
		return (index/2);
	}
	
	private T getParent(int index) {
		return heapArray[getParentIndex(index)];
	}
	
	private boolean hasLeftChild(int index) {
		return (getLeftChildIndex(index) <= this.sizeOfHeap);
	}
	
	private boolean hasRightChild(int index) {
		return (getRightChildIndex(index) <= this.sizeOfHeap);
	}
}
