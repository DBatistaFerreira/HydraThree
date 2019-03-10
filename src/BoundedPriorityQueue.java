import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant({"$this.sizeOfHeap >= 0",
			"$this.boundCapacity > 0",
			"$this.sizeOfHeap <= $this.boundCapacity"})
public class BoundedPriorityQueue<T>{
	
	public int sizeOfHeap;
	public int boundCapacity;
	
	public Node<T>[] heapArray;
	
	@SuppressWarnings("unchecked")
	@requires({"true"})
	@ensures({"$this.heapArray != null",
		      "$this.boundCapacity > 0"})
	public BoundedPriorityQueue() {
		this.boundCapacity = 10;
		this.heapArray = new Node[this.boundCapacity+1];
		this.sizeOfHeap = 0;
	}
	
	@SuppressWarnings("unchecked")
	@requires({"boundCapacity > 0"})
	@ensures({"$this.heapArray != null",
    		  "$this.boundCapacity > 0"})
	public BoundedPriorityQueue(int boundCapacity) {
		this.boundCapacity = boundCapacity;
		this.heapArray = new Node[this.boundCapacity+1];
		this.sizeOfHeap = 0;
	}

	@requires({"newItem != null",
			   "key != null",
			   "$this.sizeOfHeap < $this.boundCapacity"})
	@ensures({"$this.sizeOfHeap == $old($this.sizeOfHeap) + 1",
		      "$this.contains(newItem)"})
	public void insert(T newItem, Integer key) {
		this.sizeOfHeap++;
		heapArray[sizeOfHeap] = new Node<>(newItem, key);
		heapifyUp();
	}
	
	@requires({"$this.sizeOfHeap != 0"})
	@ensures({"$result != null",
		      "$result == $old($this.min())",
			  "$this.sizeOfHeap == $old($this.sizeOfHeap) - 1"})
	public T remove() {
		T highestPriority = min();
		
		heapArray[1] = heapArray[sizeOfHeap];
		heapArray[sizeOfHeap] = null;
		sizeOfHeap--;
		
		heapifyDown();
		
		return highestPriority; 
	}
	
	@requires({"$this.sizeOfHeap != 0"})
	@ensures({"$result != null",
		      "$this.sizeOfHeap == $old($this.sizeOfHeap)",
		      "$result == $old($this.min())"})
	public T min() {
		return heapArray[1].getElement();
	}
	
	@requires({"element != null"})
	@ensures({"$result == $old($this.contains(element))"})
	public boolean contains(T element) {
		for (int i = 1; i <= sizeOfHeap; i++) {
			if(heapArray[i].getElement().equals(element)) {
				return true;
			}
		}
		return false;
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
		Node<T> temp = heapArray[indexOne];
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
	
	private Node<T> getParent(int index) {
		return heapArray[getParentIndex(index)];
	}
	
	private boolean hasLeftChild(int index) {
		return (getLeftChildIndex(index) <= this.sizeOfHeap);
	}
	
	private boolean hasRightChild(int index) {
		return (getRightChildIndex(index) <= this.sizeOfHeap);
	}
	
	private static class Node<T> implements Comparable<Node<T>> {
		private Integer key;
		private T element;
		
		public Node(T element, Integer key) {
			this.element = element;
			this.key = key;
		}
		
		public T getElement() {
			return element;
		}
		
		@Override
		public int compareTo(Node<T> node) {
			return (this.key - node.key);
		}
	}
}
