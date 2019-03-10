
public class PriorityQueueDriver {

	public static PriorityQueueDriver priorityQueueDriver = new PriorityQueueDriver();
	
	public static void main(String[] args) {
		try {
			priorityQueueDriver.run();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		BoundedPriorityQueue<Integer> priorityQueue = new BoundedPriorityQueue<>(5);
		priorityQueue.insert(10, 1);
		priorityQueue.insert(5, 1);
		priorityQueue.insert(25, 1);
		priorityQueue.insert(10, 1);
		priorityQueue.insert(5, 1);
		//priorityQueue.insert(25, 1);
		
		BoundedPriorityQueue<String> priorityQueueStrings = new BoundedPriorityQueue<>(10);
		priorityQueueStrings.insert("Hello1", 3);
		priorityQueueStrings.insert("HelloWorldWorld", 2);
		priorityQueueStrings.insert("Hello", 1);
		
		System.out.println(priorityQueue.min());
		System.out.println(priorityQueueStrings.min());
		
		
	}
}
