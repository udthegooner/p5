/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          p5
// FILE:             NavigationGraph.java
//
// TEAM:    p5team
// Authors: Collin Lacy, clacy@wisc.edu, clacy, Lecture 001
// Author1: (name1,email1,netID1,lecture number1)
// Author2: (name2,email2,netID2,lecture number2)
//
//////////////////////////// 80 columns wide //////////////////////////////////



import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Navigation Graph
 * @author Lacy
 */
public class NavigationGraph implements GraphADT<Location, Path> {
	
	//ArrayList that holds GraphNodes
	private List<GraphNode<Location, Path>> adjacencyList;
	//String array that holds edge properties (e.g. Time, Cost)
	private String[] edgePropertyNames;
	//UniqueID for each Location Vertex, index starting at 0
	private int uniqueID = 0;
	//List of vertices to cut down on complexity with getVertices method
	private List<Location> vertices;

	/**
	 * Constructor for NavigationGraph
	 */
	public NavigationGraph(String[] edgePropertyNames) {
		this.adjacencyList = new ArrayList<GraphNode<Location, Path>>();
		this.edgePropertyNames = edgePropertyNames;
		this.vertices = new ArrayList<Location>();
	}
	
	/**
	 * Returns a Location object given its name
	 * 
	 * @param name
	 *            name of the location
	 * @return Location object
	 */
	public Location getLocationByName(String name) {
		//For each Location in the list, check to see if its name matches the name passed in
		for (int i = 0; i < adjacencyList.size(); i++) {
			if (adjacencyList.get(i).getVertexData().getName().equals(name)) {
				return adjacencyList.get(i).getVertexData();
			}
		}
		//Else return null
		return null;  
	}

	/**
	 * Adds a vertex to the Graph
	 * 
	 * @param vertex
	 *            vertex to be added
	 */
	@Override
	public void addVertex(Location vertex) {
		GraphNode<Location, Path> node = new GraphNode<Location, Path>(vertex, getUniqueID(uniqueID));
		adjacencyList.add(node);
		vertices.add(vertex);
	}
	
	/**
	 * Returns a uniqueID for the vertex to be added
	 * 
	 * @param vertex
	 *            vertex to be added
	 */
	private int getUniqueID(int uniqueID) {
		return uniqueID++;
	}


	@Override
	public void addEdge(Location src, Location dest, Path edge) {
		// Find the source node in our list, if equal, add the edge
		for (int i = 0; i < adjacencyList.size(); i++) {
			if (adjacencyList.get(i).equals(src)) {
				adjacencyList.get(i).addOutEdge(edge);
			}
		}
	}


	@Override
	public List<Location> getVertices() {
		// Return the list of vertices
		return vertices;
	}


	@Override
	public Path getEdgeIfExists(Location src, Location dest) {
		
		// Find the src in our adjacencyList, then look through that vertex's
		// edges.
		for (int i = 0; i < adjacencyList.size(); i++) {
			if (adjacencyList.get(i).equals(src)) {
				List<Path> edges = adjacencyList.get(i).getOutEdges();
				// Once we find our source, check if it has the edge
				for (int j = 0; j < edges.size(); j++) {
					if (edges.get(j).getSource().equals(src) && edges.get(j).getDestination().equals(dest)) {
						return edges.get(i);
					}
				}
			}
		}
		
		return null;
	}


	@Override
	public List<Path> getOutEdges(Location src) {
		for (int i = 0; i < adjacencyList.size(); i++) {
			if (adjacencyList.get(i).equals(src)) {
				return adjacencyList.get(i).getOutEdges();
			}
		}
		return null;
	}


	@Override
	public List<Location> getNeighbors(Location vertex) {
		
		// List that holds all neighbors
		List<Location> neighbors = new ArrayList<Location>();
		// Holds list of edges out of specified vertex
		List<Path> edges = new ArrayList<Path>();
		// Holds index in adjacencyList of vertex of interest.
		int index = -1;
		
		// Cycle through our vertices list to find the index of the vertex.
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).equals(vertex)) {
				index = i;
				break;
			}
		}
		
		// Return the list of edges at that index.
		edges = adjacencyList.get(index).getOutEdges();
		// Put all destination locations into new list
		for (int i = 0; i < edges.size(); i++) {
			neighbors.add(edges.get(i).getDestination());
		}
		
		return neighbors;
	}


	@Override
	public List<Path> getShortestRoute(Location src, Location dest, String edgePropertyName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] getEdgePropertyNames() {
		return edgePropertyNames;
	}

}
