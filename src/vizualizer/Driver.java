package vizualizer;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Driver {
	public static void main(String[] args){
		new Driver();
	}
	
	public Driver(){
		Graph graph = new Graph();
		final int NUMBEROFVERTICES = 5;
		for(int i = 0; i < NUMBEROFVERTICES; i++){
			Vertex vertexToAdd = new Vertex(i);
			graph.addVertex(vertexToAdd);
		}
		final int NUMBEROFEDGES = 4;
		Edge[] edgeArray = new Edge[NUMBEROFEDGES];
		edgeArray[0] = new Edge(graph.getVertexList().get(0),graph.getVertexList().get(1));
		edgeArray[1] = new Edge(graph.getVertexList().get(0),graph.getVertexList().get(2));
		edgeArray[2] = new Edge(graph.getVertexList().get(2),graph.getVertexList().get(3));
		edgeArray[3] = new Edge(graph.getVertexList().get(2),graph.getVertexList().get(4));
		for(int j = 0; j < NUMBEROFEDGES; j++){
			graph.addEdge(edgeArray[j]);
		}
		
		Visualizer visual = new Visualizer(graph);
		visual.makeGUI();
		visual.showValues();
	}
}
