package DiGraph_A5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
	Node lastNode;
	HashMap<String, Node> nodeLabelMap;
	HashMap<Long, Node> nodeIdNumMap;
	HashMap<Long, Edge> edgeIdNumMap;
	HashMap<String, Edge> edgeLabelMap;
	int nodeCount;
	int edgeCount;
	
  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	  nodeLabelMap = new HashMap<String, Node>();
	  nodeIdNumMap = new HashMap<Long, Node>();
	  edgeIdNumMap = new HashMap<Long, Edge>();
	  edgeLabelMap = new HashMap<String, Edge>();
	  lastNode = null;
	  nodeCount = 0;
	  edgeCount = 0;
  }

  //rest of your code to implement the various operations
  
@Override
public boolean addNode(long idNum, String label) {
	// description in interface
	if (idNum < 0) {
		return false;
	} else if (label == null) {
		return false;
	} else if (nodeLabelMap.containsKey(label)) {
		return false;
	} else if (nodeIdNumMap.containsKey(idNum)) {
		return false;
	} else {
		Node temp = new Node(idNum, label);
		nodeLabelMap.put(label, temp);
		nodeIdNumMap.put(idNum, temp);
		if (lastNode != null) {
			lastNode.child = temp;
			temp.parent = lastNode;
		} else {
			lastNode = temp;
		}
		nodeCount++;
		return true;
	}
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	// description in interface
	if (idNum < 0) {
		return false;
	} else if (sLabel == null) {
		return false;
	} else if (dLabel == null) {
		return false;
	} else if (edgeIdNumMap.containsKey(idNum)) {
		return false;
	} else if (!nodeLabelMap.containsKey(sLabel) || !nodeLabelMap.containsKey(dLabel)) {
		return false;
	} else if (edgeLabelMap.containsKey(sLabel + "+" + dLabel)) {
		return false;
	} else {
		Edge temp = new Edge(idNum, sLabel, dLabel, weight, eLabel);
		edgeIdNumMap.put(idNum, temp);
		edgeLabelMap.put(sLabel + "+" + dLabel, temp);
		nodeLabelMap.get(sLabel).outEdges.put(idNum, temp);
		nodeLabelMap.get(sLabel).adj.add(nodeLabelMap.get(dLabel));
		nodeLabelMap.get(dLabel).inEdges.put(idNum, temp);
	}
	edgeCount++;
	return true;
}

public boolean addEdge(long idNum, String sLabel, String dLabel, String eLabel) {
	// description in interface
	// weight not provided --> defaults to 1
	if (idNum < 0) {
		return false;
	} else if (sLabel == null) {
		return false;
	} else if (dLabel == null) {
		return false;
	} else if (edgeIdNumMap.containsKey(idNum)) {
		return false;
	} else if (!nodeLabelMap.containsKey(sLabel) || !nodeLabelMap.containsKey(dLabel)) {
		return false;
	} else if (edgeLabelMap.containsKey(sLabel + "+" + dLabel)) {
		return false;
	} else {
		Edge temp = new Edge(idNum, sLabel, dLabel, eLabel);
		edgeIdNumMap.put(idNum, temp);
		edgeLabelMap.put(sLabel + "+" + dLabel, temp);
		nodeLabelMap.get(sLabel).outEdges.put(idNum, temp);
		nodeLabelMap.get(sLabel).adj.add(nodeLabelMap.get(dLabel));
		nodeLabelMap.get(dLabel).inEdges.put(idNum, temp);
	}
	edgeCount++;
	return true;
}

@Override
public boolean delNode(String label) {
	// description in interface
	if (!nodeLabelMap.containsKey(label)) {
		return false;
	} else {
		Node targetNode = nodeLabelMap.get(label);
		if (!targetNode.inEdges.isEmpty()) {
			// remove inEdges from everything
			Iterator<Entry<Long, Edge>> inIterator = targetNode.inEdges.entrySet().iterator();
			while (inIterator.hasNext()) {
				Map.Entry<Long, Edge> tempEntry = (Map.Entry<Long, Edge>) inIterator.next();
				Edge tempEdge = targetNode.inEdges.get(tempEntry.getKey());
				Node tempSourceNode = nodeLabelMap.get(tempEdge.sLabel);
				tempSourceNode.outEdges.remove(tempEntry.getKey());
				edgeIdNumMap.remove(tempEdge.idNum);
				edgeLabelMap.remove(tempEdge.sLabel + "+" + tempEdge.dLabel);
				inIterator.remove();
			}
		}
		if (!targetNode.outEdges.isEmpty()) {
			// remove outEdges from everything;
			Iterator<Entry<Long, Edge>> outIterator = targetNode.outEdges.entrySet().iterator();
			while (outIterator.hasNext()) {
				Map.Entry<Long, Edge> tempEntry = (Map.Entry<Long, Edge>) outIterator.next();
				Edge tempEdge = targetNode.outEdges.get(tempEntry.getKey());
				Node tempDestinationNode = nodeLabelMap.get(tempEdge.dLabel);
				tempDestinationNode.inEdges.remove(tempEntry.getKey());
				edgeIdNumMap.remove(tempEdge.idNum);
				edgeLabelMap.remove(tempEdge.sLabel + "+" + tempEdge.dLabel);
				outIterator.remove();
			}
		}
		if (targetNode.parent == null && targetNode.child == null) {
			lastNode = null;
		} else if (targetNode.child == null) {
			targetNode.parent.child = null;
			lastNode = targetNode.parent;
		} else if (targetNode.parent == null) {
			targetNode.child.parent = null;
		} else {
			targetNode.parent.child = targetNode.child;
			targetNode.child.parent = targetNode.parent;
		}
		nodeIdNumMap.remove(targetNode.idNum);
		nodeLabelMap.remove(label);
	}
	nodeCount--;
	return true;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	// description in interface
	if(!nodeLabelMap.containsKey(sLabel) || !nodeLabelMap.containsKey(dLabel)){
		return false;
	} else if (!edgeLabelMap.containsKey(sLabel + "+" + dLabel)) {
		return false;
	} else {
		Edge targetEdge = edgeLabelMap.get(sLabel + "+" + dLabel);
		long targetEdgeId = targetEdge.idNum;
		nodeLabelMap.get(sLabel).outEdges.remove(targetEdgeId);
		nodeLabelMap.get(dLabel).inEdges.remove(targetEdgeId);
		edgeLabelMap.remove(sLabel + "+" + dLabel);
		edgeIdNumMap.remove(targetEdgeId);
	}
	edgeCount--;
	return true;
}

@Override
public long numNodes() {
	// description in interface
	return nodeCount;
}

@Override
public long numEdges() {
	// description in interface
	return edgeCount;
}

@Override
public ShortestPathInfo[] shortestPath(String label) {
	PriorityQueue<ShortestPathInfo> PQ = new PriorityQueue<ShortestPathInfo>();
	Node startNode = nodeLabelMap.get(label);
	int knownNodes = 0;
	ShortestPathInfo[] solutionArray = new ShortestPathInfo[(int) (this.numNodes())];
	Iterator<Entry<String, Node>> nodeIterator = nodeLabelMap.entrySet().iterator();
	while (nodeIterator.hasNext()) {
		Map.Entry<String, Node> tempEntry = (Map.Entry<String, Node>) nodeIterator.next();
		Node tempNode = nodeLabelMap.get(tempEntry.getKey());
		tempNode.dist = Integer.MAX_VALUE;
		tempNode.known = false;
	}

	startNode.dist = 0;
	PQ.add(new ShortestPathInfo(label, 0));
	while(!PQ.isEmpty()) {
		ShortestPathInfo tempSPI = PQ.remove();
		Node tempNode = nodeLabelMap.get(tempSPI.getDest());
		if (!tempNode.known) {
			tempNode.known = true;
			solutionArray[knownNodes] = tempSPI;
			knownNodes++;
			if (!tempNode.adj.isEmpty()) {
				Iterator<Node> adjIterator = tempNode.adj.iterator();
				while(adjIterator.hasNext()) {
					Node adjNode = adjIterator.next();
					if(!adjNode.known) {
						long edgeCostToAdj = edgeLabelMap.get(tempNode.label + "+" + adjNode.label).weight;
						if((tempNode.dist + edgeCostToAdj) < adjNode.dist) {
							adjNode.dist = (int) (tempNode.dist + edgeCostToAdj);
							adjNode.path = tempNode;
							PQ.add(new ShortestPathInfo(adjNode.label, adjNode.dist));
						}
					}
				}
			}
		}
	}
	Iterator<Entry<String, Node>> nodeIterator2 = nodeLabelMap.entrySet().iterator();
	while (nodeIterator2.hasNext()) {
		Map.Entry<String, Node> tempEntry = (Map.Entry<String, Node>) nodeIterator2.next();
		Node tempNode = nodeLabelMap.get(tempEntry.getKey());
		if(!tempNode.known) {
			solutionArray[knownNodes] = new ShortestPathInfo(tempNode.label, -1);
			knownNodes++;
		}
	}
	return solutionArray;
} 
}