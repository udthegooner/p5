import java.util.Comparator;

public class PriorityQueueEntry implements Comparator<GraphNode<Location, Path>>{
	
	GraphNode<Location, Path> node;
	double weight;
	
	
	public PriorityQueueEntry(double weight, GraphNode<Location, Path> node) {
		this.node = node;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
	
	//TODO: How to access weight properly?
	@Override
	public int compare(GraphNode<Location, Path> node1, GraphNode<Location, Path> node2) {
		if (node1.getWeight() > node2.getWeight()) {
			return 1;
		}
		else if (node1.getWeight() < node2.getWeight()) {
			return -1;
		}
		else{
			return 0;
		}
	}
}
