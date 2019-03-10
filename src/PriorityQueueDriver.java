
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
		priorityQueue.insert(10);
		priorityQueue.insert(5);
		priorityQueue.insert(25);
		
		BoundedPriorityQueue<String> priorityQueueStrings = new BoundedPriorityQueue<>(10);
		priorityQueueStrings.insert("HelloWorld");
		priorityQueueStrings.insert("HelloWorldWorld");
		priorityQueueStrings.insert("Hello");
		
		System.out.print(priorityQueue.min());
		System.out.print(priorityQueueStrings.min());
		
		
	}
}
