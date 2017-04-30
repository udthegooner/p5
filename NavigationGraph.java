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
/**
 * Navigation Graph
 * @author Lacy
 */
public class NavigationGraph implements GraphADT<Location, Path> {
	
	private List<GraphNode<Location, Path>> nodes; //ArrayList that holds GraphNodes
	private String[] edgePropertyNames; //String array that holds edge properties (e.g. Time, Cost)
	private int uniqueID; //UniqueID for incoming node
	private List<Location> vertices; //List of vertices to cut down on complexity with getVertices method

	/**
	 * Constructor for NavigationGraph
	 */
	public NavigationGraph(String[] edgePropertyNames) {
		this.nodes = new ArrayList<GraphNode<Location, Path>>();
		this.edgePropertyNames = edgePropertyNames;
		this.vertices = new ArrayList<Location>();
		this.uniqueID = 0;
	}
	
	/**
	 * Returns a Location object given its name
	 * 
	 * @param name
	 *            name of the location
	 * @return Location object
	 */
	public Location getLocationByName(String name) {
		//For each node in the list, check to see if its name matches the parameter
		for (int i = 0; i < nodes.size(); i++)
			if (nodes.get(i).getVertexData().getName().equals(name))
				return nodes.get(i).getVertexData();
		
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
		//check if location to be added already exists in graph
		if (!vertices.contains(vertex)){
			nodes.add(new GraphNode<Location, Path>(vertex, uniqueID));
			vertices.add(vertex);
			uniqueID++;
		}
	}

	/**
	 * Creates a directed edge from src to dest
	 * 
	 * @param src
	 *            source vertex from where the edge is outgoing
	 * @param dest
	 *            destination vertex where the edge is incoming
	 * @param edge
	 *            edge between src and dest
	 */
	@Override
	public void addEdge(Location src, Location dest, Path edge) {
		int flag = 0;
		
		// loop that runs through nodes list
		for (int i = 0; i < nodes.size(); i++)
			//check if node location matches src
			if (nodes.get(i).equals(src)) {
				//check if vertices contains destination
				if (vertices.contains(dest)){
					nodes.get(i).addOutEdge(edge);
					flag = 2;
				}
				else
					flag = 1;
				break;
			}

			
		if (flag == 0)
			throw new IllegalArgumentException("Source location not found");
		else if (flag == 1)
			throw new IllegalArgumentException("Destination location not found");
	}

	/**
	 * Getter method for the vertices
	 * 
	 * @return List of vertices of type V
	 */
	@Override
	public List<Location> getVertices() {
		return vertices;
	}

	/**
	 * Returns edge if there is one from src to dest vertex else null
	 * 
	 * @param src
	 *            Source vertex
	 * @param dest
	 *            Destination vertex
	 * @return Edge of type E from src to dest
	 */
	@Override
	public Path getEdgeIfExists(Location src, Location dest) {
		
		//loop that runs through nodes list until node with src is found
		for (GraphNode<Location, Path> node: nodes)
			//check if node location is same as src
			if (node.getVertexData().equals(src)) {
				//loop that runs through each edge of src node
				for (Path edge: node.getOutEdges())
					//check if edge location is same as dest
					if (edge.getDestination().equals(dest))
						return edge;
				return null;
			}
		
		//TODO what do we do if src or dest do not exist. Piazza post made.
		return null;
	}

	/**
	 * Returns the outgoing edges from a vertex
	 * 
	 * @param src
	 *            Source vertex for which the outgoing edges need to be obtained
	 * @return List of edges of type E
	 */
	@Override
	public List<Path> getOutEdges(Location src) {
		for (int i = 0; i < nodes.size(); i++)
			if (nodes.get(i).equals(src))
				return nodes.get(i).getOutEdges();
		throw new IllegalArgumentException("Source destination does not exist");
	}

	/**
	 * Returns neighbors of a vertex
	 * 
	 * @param vertex
	 *            vertex for which the neighbors are required
	 * @return List of vertices(neighbors) of type V
	 */
	@Override
	public List<Location> getNeighbors(Location vertex) {
		List<Path> edges = getOutEdges(vertex);
		List<Location> neighbors = new ArrayList<Location>();
		for (Path path: edges)
			neighbors.add(path.getDestination());
		
		return neighbors;
	}

	/**
	 * Calculate the shortest route from src to dest vertex using
	 * edgePropertyName
	 * 
	 * @param src
	 *            Source vertex from which the shortest route is desired
	 * @param dest
	 *            Destination vertex to which the shortest route is desired
	 * @param edgePropertyName
	 *            edge property by which shortest route has to be calculated
	 * @return List of edges that denote the shortest route by edgePropertyName
	 */
	@Override
	public List<Path> getShortestRoute(Location src, Location dest, String edgePropertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter method for edge property names
	 * 
	 * @return array of String that denotes the edge property names
	 */
	@Override
	public String[] getEdgePropertyNames() {
		return edgePropertyNames;
	}
	
	/**
	 * Return a string representation of the graph
	 * 
	 * @return String representation of the graph
	 */
	public String toString(){
		//TODO
		return null;
	}

}

