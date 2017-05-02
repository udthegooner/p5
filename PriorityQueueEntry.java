import java.util.Comparator;

public class PriorityQueueEntry implements Comparable<PriorityQueueEntry>{

	GraphNode<Location, Path> node;
	PriorityQueueEntry prev;
	double weight;
	boolean visited;


	public PriorityQueueEntry(double weight, GraphNode<Location, Path> node, PriorityQueueEntry prev) {
		this.weight = weight;
		this.node = node;
		this.prev = prev;
		this.visited = false;
	}

	@Override
	public int compareTo(PriorityQueueEntry otherEntry) {
		if (weight < otherEntry.weight) {
			return -1;
		}
		else if (weight > otherEntry.weight) {
			return 1;
		}
		return 0;
	}
	
	public boolean isVisited() {
		return visited;
	}
	public void setVisited() {
		this.visited = true;
	}

	public GraphNode<Location, Path> getNode() {
		return node;
	}

	public PriorityQueueEntry getPrev() {
		return prev;
	}

	public double getWeight() {
		return weight;
	}

	public void setNode(GraphNode<Location, Path> node) {
		this.node = node;
	}

	public void setPrev(PriorityQueueEntry prev) {
		this.prev = prev;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
