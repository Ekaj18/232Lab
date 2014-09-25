package graph;
import java.util.ArrayList;
import java.util.List;


public class Graph {
	private List<Vertex> vertexList = new ArrayList<>();
	private List<Edge> edgeList = new ArrayList<>();
	
	public void addVertex(Vertex vertexToAdd){
		vertexList.add(vertexToAdd);
	}
	
	public void addEdge(Edge edgeToAdd){
		edgeList.add(edgeToAdd);
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}
	
	public void removeVertex(Vertex vertex){
		vertexList.remove(vertex);
	}
	
	public void removeEdge(Edge edge){
		edgeList.remove(edge);
	}
	
	public void clearEdgeList(){
		edgeList.clear();
	}
}
