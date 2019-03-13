
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
			//Employee Priority Queue (Capacity of 3)
			System.out.println("Creating a Employee Priority Queue and Setting their keys");
			BoundedPriorityQueue<Employee> employeePQ = new BoundedPriorityQueue<>(3);
			employeePQ.insert(new Employee("Bobby", 70000), 3);
			employeePQ.insert(new Employee("Bob", 80000), 2);
			employeePQ.insert(new Employee("Boberta", 90000), 1);

			for(int i = 0; i < 3; i++) {
				if(i == 2) {
					System.out.print(employeePQ.remove().getName());
				}
				else {
					System.out.print(employeePQ.remove().getName() + " -> ");
				}
			}
		
		//Insert Precondition Failures
		
		//Min Precondition Failures 
		
		//Remove Precondition Failures
		
		
	}
}
