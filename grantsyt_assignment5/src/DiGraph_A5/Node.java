package DiGraph_A5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node implements NodeInterface {
	public String label;
	public Long idNum;
	public Node parent;
	public Node child;
	public HashMap<Long, Edge> outEdges;
	public HashMap<Long, Edge> inEdges;
	
	public List<Node> adj;
	public boolean known;
	public int dist;
	public Node path;
	
	public Node (Long idNum, String label) {
		this.label = label;
		this.idNum = idNum;
		outEdges = new HashMap<Long, Edge>();
		inEdges = new HashMap<Long, Edge>();
		this.adj = new ArrayList<Node>();
	}
}
