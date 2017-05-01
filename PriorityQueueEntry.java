import java.util.Comparator;

public class PriorityQueueEntry implements Comparable<PriorityQueueEntry>{

	GraphNode<Location, Path> node;
	double weight;


	public PriorityQueueEntry(double weight, GraphNode<Location, Path> node) {
		this.node = node;
		this.weight = weight;
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
}
