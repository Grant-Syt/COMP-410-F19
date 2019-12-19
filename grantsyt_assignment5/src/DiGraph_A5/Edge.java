package DiGraph_A5;

public class Edge {
	long weight;
	long idNum;
	String sLabel;
	String dLabel;
	String eLabel = null;
	
	public Edge (long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		this.weight = weight;
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.eLabel = eLabel;
	}
	
	public Edge (long idNum, String sLabel, String dLabel, String eLabel) {
		this.weight = 1;
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.eLabel = eLabel;
	}
}
