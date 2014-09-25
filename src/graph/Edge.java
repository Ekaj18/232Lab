package graph;

public class Edge {
	private int edgeValue;
	public int getEdgeValue() {
		return edgeValue;
	}

	public void setEdgeValue(int edgeValue) {
		this.edgeValue = edgeValue;
	}

	public Vertex getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex vertex2) {
		this.vertex2 = vertex2;
	}

	private Vertex vertex1;
	private Vertex vertex2;
	
	public Edge(Vertex vertex1, Vertex vertex2){
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
}
