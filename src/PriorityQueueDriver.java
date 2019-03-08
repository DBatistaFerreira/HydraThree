
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
		
		//Breaks the Invariant of the BoundedPriorityQueue 
		BoundedPriorityQueue<Integer> priorityQueue = new BoundedPriorityQueue<>(-5);
		
		//Runs fine
		BoundedPriorityQueue<Integer> priorityQueueTwo = new BoundedPriorityQueue<>(10);	
	}
}
