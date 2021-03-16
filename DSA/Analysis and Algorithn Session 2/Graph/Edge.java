package main;

/**
 * Class for Representing Edge of a Graph.
 * @author vishnu.jangid_metacu
 *
 */
public class Edge {
	
	public final int vertex1;
	public final int vertex2;
	public final int weight;
	
	/**
	 * Constructor
	 * @param vertex1 int
	 * @param vertex2 int
	 * @param weight int
	 */
	public Edge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	
}
