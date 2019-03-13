
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
		
		System.out.println("Demo for SOEN 331 - Assignment 3");
		System.out.println("By: Daniel Batista-Ferreira, Jake Bedard, Cristian Aldea, and Nathan Ziri");
		System.out.println("--------------------------------------------------------------------------");
		//Priority Queue ADT Demonstrations
			//Integer Priority Queue (Capacity of 5)
			System.out.println("Creating an Integer Priority Queue and Setting their keys");
			BoundedPriorityQueue<Integer> integerPQ = new BoundedPriorityQueue<>(5);
			integerPQ.insert(3, 3);
			integerPQ.insert(2, 2);
			integerPQ.insert(1, 1);
			integerPQ.insert(4, 4);
			integerPQ.insert(5, 5);
			
			// So this order should be from lowest to highest integer priority wise
			for(int i = 0; i < 5; i++) {
				if(i == 4) {
					System.out.print(integerPQ.remove());
				}
				else {
					System.out.print(integerPQ.remove() + " -> ");
				}
			}
			System.out.println("\n--------------------------------------------------------------------------");
		
			//String Priority Queue (Capacity of 4)
			System.out.println("Creating an String Priority Queue and Setting their keys");
			BoundedPriorityQueue<String> stringPQ = new BoundedPriorityQueue<>(4);
			stringPQ.insert("ABC", 4);
			stringPQ.insert("Easy as", 2);
			stringPQ.insert("123", 3);
			stringPQ.insert("ABC", 1);
			
			//So the PQ should release them as ABC Easy As 123 ABC
			for(int i = 0; i < 4; i++) {
				if(i == 3) {
					System.out.print(stringPQ.remove());
				}
				else {
					System.out.print(stringPQ.remove() + " -> ");
				}
			}
			System.out.println("\n--------------------------------------------------------------------------");
			
		//Constructor Precondition Failures
			//Uncomment this to fail the bound capacity precondition
//				BoundedPriorityQueue<Integer> integerPQ2 = new BoundedPriorityQueue<>(-1);
			
		//Insert Precondition Failures
			BoundedPriorityQueue<Integer> integerPQ3 = new BoundedPriorityQueue<>(3);
			//Uncomment this to fail the key being null precondition
//				integerPQ3.insert(5, null);
			//Uncomment this to fail the element being null precondition
//				integerPQ3.insert(null, 5);
			//Uncomment this to fail the bound capacity 
//				integerPQ3.insert(1, 1);
//				integerPQ3.insert(2, 2);
//				integerPQ3.insert(3, 3);
//				integerPQ3.insert(4, 4);
			
		//Min Precondition Failures 
			BoundedPriorityQueue<Integer> integerPQ4 = new BoundedPriorityQueue<>(3);
			//Uncomment this to fail the size being equal to 0 precondition
//				integerPQ4.min();
			
		//Remove Precondition Failures
			BoundedPriorityQueue<Integer> integerPQ5 = new BoundedPriorityQueue<>(3);
			//Uncomment this to fail the size being equal to 0 precondition
//				integerPQ5.remove();
			
		//Contains Precondition Failures
			BoundedPriorityQueue<Integer> integerPQ6 = new BoundedPriorityQueue<>(3);
			//Uncomment this to fail the contains method being sent null
//				integerPQ6.contains(null);
	}
}
