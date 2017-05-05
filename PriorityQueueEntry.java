// Semester:         CS367 Spring 2016 
// PROJECT:          p5
// FILE:             PriorityQueueEntry.java
//
// TEAM:    p5team 79
// Authors: Collin Lacy, Udhbhav Gupta
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Comparator;
/**
 * PriorityQueueEntry-This is a wrapper class for our graphnode
 * 
 * @author Collin Lacy, Udhbhav Gupta
 */
public class PriorityQueueEntry implements Comparable<PriorityQueueEntry>{

	GraphNode<Location, Path> node; //The graph node
	PriorityQueueEntry prev; //The previous PriorityQueueEntry
	double weight; //Weight of the PriorityQueueEntry
	boolean visited; //Whether or not entry has been visited

	/**
	 * Constructor for PriorityQueueEntry
	 */
	public PriorityQueueEntry(double weight, GraphNode<Location, Path> node, PriorityQueueEntry prev) {
		this.weight = weight;
		this.node = node;
		this.prev = prev;
		this.visited = false;
	}

	/**
	 * Compares two PriorityQueueEntrys
	 * 
	 * @param otherEntry
	 *            PriorityQueueEntry to compare to
	 * @return -1 if this PriorityQueueEntry is less 
	 * than other, 1 if this is greater than other, and 0 if they are the same
	 */
	public int compareTo(PriorityQueueEntry otherEntry) {
		if (weight < otherEntry.weight) {
			return -1;
		}
		else if (weight > otherEntry.weight) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Returns whether or not node is visited
	 * 
	 * @return whether PriorityQueueEntry has been visited
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * Sets node to visited
	 */
	public void setVisited() {
		this.visited = true;
	}

	/**
	 * Returns node
	 * 
	 * @return The Graphnode stored in the PriorityQueueEntry
	 */
	public GraphNode<Location, Path> getNode() {
		return node;
	}

	/**
	 * Returns previous PriorityQueueEntry
	 */
	public PriorityQueueEntry getPrev() {
		return prev;
	}

	/**
	 * Returns weight
	 * 
	 * @return the weight of the PriorityQueueEntry
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the node
	 */
	public void setNode(GraphNode<Location, Path> node) {
		this.node = node;
	}

	/**
	 * Sets the previous PriorityQueueEntry
	 */
	public void setPrev(PriorityQueueEntry prev) {
		this.prev = prev;
	}

	/**
	 * Sets the weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
