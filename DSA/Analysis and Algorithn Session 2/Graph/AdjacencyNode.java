package main;

/**
 * Class to Represent node of Adjacency list
 * @author vishnu.jangid_metacu
 *
 */
public class AdjacencyNode {
	
	public int vertex;
	public AdjacencyNode nextVertex;
	
	/**
	 * Constructor
	 * @param vertex int
	 */
	public AdjacencyNode(int vertex){
		this.vertex = vertex; 
	}
}
