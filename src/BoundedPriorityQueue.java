import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant({"this.capacity > 0"})
public class BoundedPriorityQueue<T> {

	public int capacity;
	
	@requires({})
	@ensures({})
	public BoundedPriorityQueue(int capacity) {
		this.capacity = capacity; 
	}
}
