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

	/**
	 * Constructor for NavigationGraph
	 */
	public NavigationGraph(String[] edgePropertyNames) {
		this.adjacencyList = new ArrayList<GraphNode<Location, Path>>();
		this.edgePropertyNames = edgePropertyNames;
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Location> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Path getEdgeIfExists(Location src, Location dest) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Path> getOutEdges(Location src) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Location> getNeighbors(Location vertex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Path> getShortestRoute(Location src, Location dest, String edgePropertyName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] getEdgePropertyNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
